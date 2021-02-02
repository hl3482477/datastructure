package com.study.leecode.one;

/**
 * @author HULU
 * @version 创建时间：2021/2/2 19:48
 */
public class ThreadPrintDemo {

    static final Object lock = new Object();

    private static int num1 = 0;

    private static int num2 = 1;

    private static int end = 100;
    volatile static boolean flag = false;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        flag = true;
                        if (num1 >= end) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "打印:" + num1);
                        num1 += 2;
                        lock.notify();
                    }
                }
            }
        }, "A");


        Thread b = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        flag = false;
                        if (num2 >= end) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "打印:" + num2);
                        num2 += 2;
                        lock.notify();
                    }
                }
            }
        }, "B");

        a.start();
        b.start();
    }
}
