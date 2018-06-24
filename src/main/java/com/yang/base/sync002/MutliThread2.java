package com.yang.base.sync002;

public class MutliThread2 {

    private static int num = 0;

    public static synchronized void printNum(String tag) {
        try {
            if (tag.equals("c")) {
                num = 100;
                System.out.println("tag c, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }
            System.out.println("tag " + tag + ", num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //在静态方法上加synchronized关键字，表示锁定.class类，独占.class类
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                MutliThread2.printNum("c");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                MutliThread2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}
