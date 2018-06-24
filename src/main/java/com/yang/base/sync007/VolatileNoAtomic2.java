package com.yang.base.sync007;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字不具备synchronized关键字的原子性（同步）
 */
public class VolatileNoAtomic2 extends Thread {

    private static AtomicInteger count = new AtomicInteger(0);

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        VolatileNoAtomic[] arr = new VolatileNoAtomic[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < 100; i++) {
            arr[i].start();
        }
    }
}
