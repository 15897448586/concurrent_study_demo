package com.zlx.concurrent_study_demo.base.cfdemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 类说明：get和join方法的区别
 */
public class JoinAndGet {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
           int i = 100;
           return 100;
        });
        future.get();
        //future.join();
    }
}
