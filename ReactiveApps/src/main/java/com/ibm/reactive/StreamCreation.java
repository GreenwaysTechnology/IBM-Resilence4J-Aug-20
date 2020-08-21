package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class StreamCreation {
    public static void createoperator() {
        //create method : push data- emit data event, push error - error event is emitted,complete
        Observable<Integer> stream = Observable.create(observer -> {
            //push
            observer.onNext(1);
            observer.onNext(2);
            //observer.onError(new RuntimeException("Errr"));
            observer.onNext(3);
            observer.onComplete();

        });

        //subscriber
        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
            System.out.println("Stream completed");
        });
    }

    public static void createStramingUsingJust() {
        //create of data
        Observable<Integer> stream = Observable.just(1, 2, 3, 4, 5, 6, 7);
        //subscriber
        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
            System.out.println("Stream completed");
        });
    }

    public static void createStramingUsingArray() {
        //create of data
        int[] list = {1, 2, 3, 4, 5, 6, 7};
        Observable<int[]> stream = Observable.fromArray(list);
        //subscriber
        stream.subscribe(data -> {
            System.out.println(data[0]);
        }, err -> System.out.println(err), () -> {
            System.out.println("Stream completed : Int Array");
        });
    }

    public static void createStramingUsingList() {
        //create of data
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> mylist =Arrays.asList(array);
        Observable stream = Observable.fromIterable(mylist);
        //subscriber
        stream.subscribe(data -> {
            System.out.println(data);
        }, err -> System.out.println(err), () -> {
            System.out.println("Stream completed : List Array");
        });
    }
    public static void main(String[] args) {
//        createoperator();
//        createStramingUsingJust();
//        createStramingUsingArray();
        createStramingUsingList();
    }
}
