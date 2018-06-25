package com.yang.base.m013;

import java.util.concurrent.SynchronousQueue;


public class UseQueue {

    public static void main(String[] args) throws Exception {

        //高性能无阻塞无界队列：ConcurrentLinkedQueue
        /*
         ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
         q.offer("a");
         q.offer("b");
         q.offer("c");
         q.offer("d");
         q.add("e");

         System.out.println(q.poll());	//a 从头部取出元素，并从队列里删除
         System.out.println(q.size());	//4
         System.out.println(q.peek());	//b
         System.out.println(q.size());	//4
         */

        /*
         //阻塞，有界队列，基于数组的阻塞队列实现
         ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);
         array.put("a");
         array.put("b");
         array.add("c");
         array.add("d");
         array.add("e");
         array.add("f");

         //array.offer("a", 3, TimeUnit.SECONDS),在规定的时间内不能加进去就失效
         System.out.println(array.offer("a", 3, TimeUnit.SECONDS));
         */

        /*
         //阻塞、无界队列，基于链表的阻塞队列实现
         LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();
         q.offer("a");
         q.offer("b");
         q.offer("c");
         q.offer("d");
         q.offer("e");
         q.add("f");
         System.out.println(q.size());

         //		for (Iterator iterator = q.iterator(); iterator.hasNext();) {
         //			String string = (String) iterator.next();
         //			System.out.println(string);
         //		}

         List<String> list = new ArrayList<String>();

         //q.drainTo(list, 3),批量的取3个元素放到list中
         System.out.println(q.drainTo(list, 3));
         System.out.println(list.size());

         for (String string : list) {
         System.out.println(string);
         }
         */

        //没有缓冲的队列，直接去执行
        final SynchronousQueue<String> q = new SynchronousQueue<String>();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(q.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                q.add("asdasd");
            }
        });
        t2.start();
    }
}
