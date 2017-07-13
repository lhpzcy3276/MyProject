package com.example.kangxin.myproject.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by kangxin on 17/7/13.
 */
public class ThreadPoolUtils {
    //（一堆人排队上公厕）
    public static ExecutorService newFixThreadPool(int nThreads){
        return Executors.newFixedThreadPool(nThreads);
    }
    //公厕里只有一个坑位
    public static ExecutorService newSingleThreadPool (){
        return Executors.newSingleThreadExecutor();
    }
    //CachedThreadPool（一堆人去一家很大的咖啡馆喝咖啡）
    public static ExecutorService newCachedThreadPool(){
        return Executors.newCachedThreadPool();
    }
    //（4个里面唯一一个有延迟执行和周期重复执行的线程池）
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize){
        return Executors.newScheduledThreadPool(corePoolSize);
    }



}
