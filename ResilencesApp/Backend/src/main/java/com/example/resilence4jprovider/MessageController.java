package com.example.resilence4jprovider;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


@RestController
@Log
public class MessageController {

    private static final int WAIT_TIME_MS = 1000;
    private int counter = 0;

    @GetMapping("/")
    public String okay() {
        return "I'm okay.";
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(WAIT_TIME_MS);
        return "I'm okay, just slow";
    }

    @GetMapping("/error")
    public String error() {
        throw new InternalServerErrorException("I'm definitely not okay!");
    }

    @GetMapping("/erratic")
    public String erratic() throws InterruptedException {
        log.info(Integer.toString(counter++));
        if (ThreadLocalRandom.current().nextInt(0, 5) != 0) {
            log.info("erratic");
            throw new InternalServerErrorException("I am erratic");
        }
        log.info("ok");
        return "For I am ok!";
    }

}