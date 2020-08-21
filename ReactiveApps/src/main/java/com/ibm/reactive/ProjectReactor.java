package com.ibm.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class ProjectReactor {

    public static void controlBackpressure() {
        Flux<Integer> producer = Flux.range(1, 100);

        producer.log().subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("Subscription is done");
                //ask the upstream how many elements you want
                //s.request(3); //requests only 3 elements
                //request all elements
                s.request(10); // request(unbound)
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("Data " + value);

            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error  " + t.getMessage());

            }

            @Override
            public void onComplete() {
                System.out.println("Completed ");

            }
        });
    }

    public static void main(String[] args) {
        Flux<String> producer = Flux.create(fluxSink -> {
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.next("Hello reactor");
            fluxSink.complete();

        });
        producer.log().subscribe();

        Flux<Integer> justproducer = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        justproducer.log().subscribe();

        Flux<Integer> rangeProducer = Flux.range(1, 100);
        rangeProducer.log().subscribe();

        controlBackpressure();
    }
}
