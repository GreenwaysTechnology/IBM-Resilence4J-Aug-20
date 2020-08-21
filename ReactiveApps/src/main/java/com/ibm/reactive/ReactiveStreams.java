package com.ibm.reactive;

import io.reactivex.rxjava3.core.Flowable;

public class ReactiveStreams {
    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4);
        flowable.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Back Pressured");
        });
    }
}
