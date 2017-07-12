package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.kangxin.myproject.R;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class Rxjava2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2);
        flowable.subscribe(subscriber);

        flowable.subscribe(consumer);

        Flowable.just("map")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s+"-ittianyu";
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });

        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(5);
        Flowable.fromIterable(list)
                .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });


        Flowable.just(list).flatMap(new Function<List<Integer>,Publisher<Integer>>() {
            @Override
            public Publisher<Integer> apply(List<Integer> integers) throws Exception {
                return Flowable.fromIterable(integers);
            }
        })
        .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });

        Flowable.fromArray(1,20,5,0,-1,8)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer.intValue()>5;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }

    Flowable<String> flowable=Flowable.create(new FlowableOnSubscribe<String>() {
        @Override
        public void subscribe(FlowableEmitter<String> e) throws Exception {
          e.onNext("hello RxJava2");
          e.onComplete();
        }
    }, BackpressureStrategy.BUFFER);

    Subscriber subscriber=new Subscriber<String>(){
        @Override
        public void onSubscribe(Subscription s) {
            System.out.println("onSubscribe");
            s.request(Long.MAX_VALUE);
        }

        @Override
        public void onNext(String s) {
            System.out.println(s);
        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onComplete() {
            System.out.println("onComplete");
        }
    };

    Consumer consumer=new Consumer<String>(){
        @Override
        public void accept(String s) throws Exception {
            System.out.println(s);
        }
    };
}
