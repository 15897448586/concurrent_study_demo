package com.zlx.concurrent_study_demo.sync;

import lombok.SneakyThrows;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zlx
 * @Date 2024/5/6 15:07
 */
public class CountDownLatchDemo3 {
    // 合并数据
    @SneakyThrows
    public static void main(String[] args) {
        Integer num = 2000000;
        CountDownLatch countDownLatch = new CountDownLatch(5);
        int[] counts = new int[10000000];
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < counts.length; i++) {
            counts[i] = i;
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());
        stopWatch.start();
        for (int i = 0; i < 5; i++) {
            int index = num * i;
            new Thread(() ->{
                int t = index;
                for (; t < index + num; t++) {
                    counts[t] = t;
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }
}
