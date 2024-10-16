package com.peng.c02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo4 {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();


    public static void main(String[] args) {
        new Thread( ()->{
            try {
                lock1.tryLock(5000, TimeUnit.MILLISECONDS);
                System.out.println( " 哲学家A拥有第1根筷子， 想要获取第2根筷子 ");
                TUtils.sleep(10);
                boolean flag = lock2.tryLock(5000, TimeUnit.MILLISECONDS);
                if ( flag) {
                    try {
                        System.out.println("哲学家A拥有第2根筷子，可以开始吃饭！");
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println("哲学家A饿死了");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock1.unlock();
            }

        }, "哲学家A").start() ;

        new Thread( ()->{
            try {
                lock2.tryLock(5000, TimeUnit.MILLISECONDS);
                System.out.println( "哲学家B拥有第2根筷子， 想要获取第1根筷子 ");

                boolean flag = lock1.tryLock(5000, TimeUnit.MILLISECONDS);
                if ( flag) {
                    try {
                        System.out.println("哲学家B拥有第2根筷子，可以开始吃饭！");
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("哲学家B饿死了");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock2.unlock();
            }
        },"哲学家B").start();
    }


}


