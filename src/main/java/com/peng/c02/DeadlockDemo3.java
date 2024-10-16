package com.peng.c02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo3 {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();



    public static void main(String[] args) {
        new Thread( ()->{

            try {
                lock1.tryLock(5000, TimeUnit.MILLISECONDS );
                System.out.println( " 哲学家A拥有第一根筷子，想要获取到第二根筷子 ");
                TUtils.sleep(10);

                try {
                    lock2.tryLock(5000,TimeUnit.MILLISECONDS);
                    System.out.println( " 哲学家A获取到第二根筷子 可以吃饭");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock2.unlock();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock1.unlock();
            }
        }, "哲学家A").start();

        new Thread( ()->{

            try {
                lock2.tryLock(5000, TimeUnit.MILLISECONDS );
                System.out.println( " 哲学家B拥有第二根筷子， 想要获取第一根筷子 ");
//                TUtils.sleep(1000);

                try {
                    lock1.tryLock(6000,TimeUnit.MILLISECONDS);
                    System.out.println( " 哲学家B获取到第一根筷子 可以吃饭");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock1.unlock();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock2.unlock();
            }
        },"哲学家B").start();

    }


}


