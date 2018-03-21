package com.example.RxJava2;


import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/7.
 */

public class RxJava02 {

    public static void main(String[] args) throws IOException {

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.print( "Observable thread is : " + Thread.currentThread().getName());
                emitter.onNext(1);
            }
        });

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.print( "Observer thread is :" + Thread.currentThread().getName());
            }
        };

        observable
                .subscribeOn(Schedulers.newThread())
                .subscribe(consumer);



    }
}
