package com.zlx.concurrent_study_demo.base.vola;



import com.zlx.concurrent_study_demo.tools.SleepTools;

import java.util.concurrent.TimeUnit;

/**
 * 类说明：演示Volatile的提供的可见性
 */
public class VolatileCase {
    private static boolean ready;
    private static int number;

    private static class PrintThread extends Thread{
        @Override
        public void run() {
            System.out.println("PrintThread is running.......");
            while(!ready){
                //System.out.println("lll");
                //Thread.sleep();
            };//无限循环
            System.out.println("number = "+number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new PrintThread().start();
        SleepTools.ms(1);
        //TimeUnit.SECONDS.sleep(1);
        number = 51;
        ready = true;
        //SleepTools.second(5);
        System.out.println("main is ended!");
    }
}
