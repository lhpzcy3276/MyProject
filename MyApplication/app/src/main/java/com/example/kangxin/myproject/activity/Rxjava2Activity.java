package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.LogUtil;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class Rxjava2Activity extends BaseActivity {
    private String Tag="Rxjava2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2);
        ButterKnife.bind(this);
        LogUtil.d(Tag+ Thread.currentThread().getName());
    }
    @OnClick({R.id.rxjava_button1,R.id.rxjava_button2,R.id.rxjava_button3,R.id.rxjava_button4,R.id.rxjava_button5,R.id.rxjava_button6,R.id.rxjava_button7,R.id.rxjava_button8})
    void mclick(View view){
        switch (view.getId()){
            case R.id.rxjava_button1:
                rxjava1();
                break;
            case R.id.rxjava_button2:
                rxjava2();
                break;
            case R.id.rxjava_button3:
                rxjava3();
                break;
            case R.id.rxjava_button4:
                break;
            case R.id.rxjava_button5:
                break;
            case R.id.rxjava_button6:
                break;
            case R.id.rxjava_button7:
                break;
            case R.id.rxjava_button8:
                break;

        }
    }



    private void rxjava1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                LogUtil.d(Tag+ "Observable thread is : " + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtil.d(Tag+"onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                LogUtil.d(Tag+value);
                LogUtil.d(Tag+ "Observer thread is :" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.d(Tag+"error");
            }

            @Override
            public void onComplete() {
                LogUtil.d(Tag+"onComplete");
            }
        });

    }

    private void rxjava2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                LogUtil.d(Tag+"Observable thread is : " + Thread.currentThread().getName());
                LogUtil.d(Tag+"emit 1");
                e.onNext(1);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        LogUtil.d(Tag+"Observer thread is :" + Thread.currentThread().getName());
                        LogUtil.d(Tag+ "onNext: " + integer);
                    }
                });

    }
    private void rxjava3() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                LogUtil.d(Tag+"subscribe"+Thread.currentThread().getName());
                e.onNext(1);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                LogUtil.d(Tag+"map"+Thread.currentThread().getName());
                return integer+"转字符串";
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtil.d(Tag+"subscribeOn"+Thread.currentThread().getName());
                LogUtil.d(Tag+s);
            }
        });
    }
}
