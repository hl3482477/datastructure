package com.study.leecode.one;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author HULU
 * @version 创建时间：2021/2/2 18:16
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {

        Random random = new Random();
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                threadLocal.set(Thread.currentThread().getName() + " " + random.nextInt(10));
                System.out.println("线程和local的值分别是" + threadLocal.get());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
