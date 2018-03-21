package com.example.RxJava2;


import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/3/7.
 */

public class RxJava01 {

    public static void main(String[] args) throws IOException {

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {
                for(int i=0;i<10;i++){
                  e.onNext(i+"");
                    e.onComplete();
                }
            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(@NonNull Object o) throws Exception {
                System.out.println(o.toString());
            }
        });



    }
}
