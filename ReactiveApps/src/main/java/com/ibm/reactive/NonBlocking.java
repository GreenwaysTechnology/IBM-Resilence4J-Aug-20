package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NonBlocking {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Hello")
                .observeOn(Schedulers.newThread())
                .map(String::toUpperCase)
                .doOnNext(d -> {
                    System.out.println(Thread.currentThread().getName());
                })
                .observeOn(Schedulers.newThread())
                .subscribe(s->{
                    System.out.println(Thread.currentThread().getName());
                });

        Thread.sleep(500);
    }
}
