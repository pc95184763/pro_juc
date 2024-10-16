package com.peng.c02;

public class DeadlockDemo {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread( ()->{
            synchronized (lock1) {
                System.out.println( " 哲学家A获取到第一根筷子 ");
                TUtils.sleep(1000);
                synchronized ( lock2) {
                    System.out.println( " 哲学家A获取到第二根筷子 ");
                }
            }

        }, "哲学家A").start();

        new Thread( ()->{
            synchronized (lock2) {
                System.out.println( " 哲学家B获取到第二根筷子 ");
//                TUtils.sleep(1000);
                synchronized ( lock1 ) {
                    System.out.println( " 哲学家B获取到第一根筷子 ");
                }
            }
        },"哲学家B").start();

    }


}


