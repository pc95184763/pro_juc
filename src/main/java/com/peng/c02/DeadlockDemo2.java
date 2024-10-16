package com.peng.c02;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo2 {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();



    public static void main(String[] args) {
        new Thread( ()->{

            lock1.lock();
            System.out.println( " 哲学家A获取到第一根筷子 ");
            TUtils.sleep(1000);
            try {
                lock2.lock();
                System.out.println( " 哲学家A获取到第二根筷子 可以吃饭");
            } finally {
                lock2.unlock();
            }
            lock1.unlock();

        }, "哲学家A").start();

        new Thread( ()->{
            lock2.lock();
            System.out.println("哲学家B获取到第二根筷子");
            try {
                lock1.lock();
                System.out.println("哲学家B获取到第一根筷子");
            } finally {
                lock1.unlock();
            }
            lock2.unlock();

        },"哲学家B").start();

    }


}


