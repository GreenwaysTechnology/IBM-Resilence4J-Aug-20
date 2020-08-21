package com.example.consumer;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@RestController
public class ServiceRequestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRequestController.class);
    private final RestTemplate restTemplate;
    private final String providerUri;
    //BulkHead declaration
    private final Bulkhead bulkhead;
    //Retry configuration
    private final Retry retry;
    //Timeout
    private final TimeLimiter timeLimiter;

    //CB
    private final CircuitBreaker circuitBreaker;

    public ServiceRequestController(RestTemplate restTemplate, @Value("${provider.uri}") String providerUri, @Value("${maxConcurrent}") int maxConcurrent) {
        this.restTemplate = restTemplate;
        this.providerUri = providerUri;
        //maxConcurrent value limits no of concurrent users allow to invoke remote api
        this.bulkhead = createBulkhead(maxConcurrent);
        this.retry = createRetry();
        this.timeLimiter = createTimeLimiter();
        this.circuitBreaker = createCircuitBreaker();
    }
    private CircuitBreaker createCircuitBreaker() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom().failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(20000)).build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("resilience-provider", circuitBreakerConfig);

        circuitBreaker.getEventPublisher().onSuccess(event -> LOGGER.info("Call success via circuit breaker"))
                .onCallNotPermitted(event -> LOGGER.info("Call denied by circuit breaker"))
                .onError(event -> LOGGER.info("Call failed via circuit breaker"));
        return circuitBreaker;
    }

    private TimeLimiter createTimeLimiter() {

        //Time limitter config
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofMillis(6000))
                .build();

        //Timer limitter
        TimeLimiter timeLimiter = TimeLimiter.of("timelimiter-app", config);


        timeLimiter.getEventPublisher().onSuccess(event -> {
            LOGGER.info("Timeout call is going");
        }).onTimeout(event -> {
            LOGGER.info("Timeout");
        }).onError(err -> {
            LOGGER.info("Error " + err.toString());
        });

        return timeLimiter;
    }

    private Retry createRetry() {
        //Retry config
        RetryConfig config = RetryConfig
                .custom()
                .maxAttempts(25)
                .waitDuration(Duration.ofSeconds(2))
                .build();

        //Retry Registry
        RetryRegistry registry = RetryRegistry.of(config);

        //Retry Instance
        Retry retry = registry.retry("app-retry");

        retry.getEventPublisher()
                .onRetry(r -> System.out.println("Retrying..... : " + r.getNumberOfRetryAttempts()))
                .onSuccess(e -> System.out.println("Retry success!!! : " + e.getNumberOfRetryAttempts()))
                .onError(e -> System.out.println("Retry error : " + e.getNumberOfRetryAttempts()));

        return retry;
    }

    //configuration methods
    private Bulkhead createBulkhead(int maxConcurrent) {
        //Configuration
        BulkheadConfig bulkheadConfig = BulkheadConfig
                .custom()
                .maxConcurrentCalls(maxConcurrent)
                .build();
        //Registry if want ; optional
        //create BulkHead object with configuration.
        Bulkhead bulkhead = Bulkhead.of("bulkhead-app", bulkheadConfig);

        //add bulk head events to watch, bulk head operations.
        bulkhead.getEventPublisher()
                .onCallPermitted(event -> LOGGER.info("Call Permitted"))
                .onCallRejected(event -> LOGGER.info("Call Rejected"))
                .onCallFinished(event -> LOGGER.info("Call Completed"));

        return bulkhead;
    }

    @GetMapping()
    public String okay() {
        return "The message of Provider Api  " + restTemplate.getForObject(providerUri, String.class);
    }

    //End point to simulate bulk head
    @GetMapping("/bulkhead")
    public String bulkHeadEndPoint() {
        //decoration only
        CheckedFunction0<String> someServiceCall = Bulkhead.decorateCheckedSupplier(bulkhead, () -> {
            //wrap remote api call.
            return "The message was " + restTemplate.getForObject(providerUri + "/slow", String.class);
        });
        //Result Handler : you may get result or Failure
        Try<String> result = Try
                .of(someServiceCall)
                .recover((throwable) -> "This is a bulkhead fallback : You may return cached Response");
        //execute the method
        return result.get(); //which tri

    }

    //Retry end point

    @GetMapping("/retry")
    public String retry() throws Exception {
        CheckedFunction0<String> retryableSupplier = Retry.decorateCheckedSupplier(retry, () -> {
            return "The message was " + restTemplate.getForObject(providerUri, String.class);
        });
        Try<String> result = Try.of(retryableSupplier)
                .recover((throwable) -> "Hello world from recovery function");
        return result.get();
    }

    @GetMapping("/timeout")
    public String timeoutEndPoint() throws Exception {
        //Timeout code has to be wrapped inside Future.
        String result = timeLimiter.executeFutureSupplier(
                () -> CompletableFuture.supplyAsync(() -> "The message was " + restTemplate.getForObject(providerUri + "/slow", String.class)));
        return result;
    }

    @GetMapping("/circuitbreaker")
    public String circuitBreakerFail(@RequestParam boolean shouldFail) {
        if (shouldFail) {
            return callServiceViaCircuitBreaker("/error");
        } else {
            return callServiceViaCircuitBreaker("/");
        }
    }
    private String callServiceViaCircuitBreaker(String uri) {
        CheckedFunction0<String> someServiceCall = CircuitBreaker.decorateCheckedSupplier(circuitBreaker,
                () -> "The message was " + restTemplate.getForObject(providerUri + uri, String.class));
        Try<String> result = Try.of(someServiceCall)
                .recover((throwable) -> "This is a circuit breaker fallback");
        return result.get();
    }


}