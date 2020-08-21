package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class StreamProcessing {
    //Stream Processing
    public static void processStreams() {
        //create of data
        Observable<Integer> stream = Observable
                .just(1, 2, 3, 4, 5, 6, 7) //source /upstream
                .map(x -> x * 2) //down stream / upstream
                .filter(i -> i < 10); //down stream /upstream
        //subscriber
        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
            System.out.println("Stream completed");
        });
    }

    public static void main(String[] args) {
        processStreams();
    }
}
