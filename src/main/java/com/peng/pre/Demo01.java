package com.peng.pre;

public class Demo01 {
    public static void main( String[] args ) {
        MyThread thread1 = new MyThread();
        thread1.setName("线程1");

        MyThread2 thread2 = new MyThread2();
        thread2.setName("线程2");

        thread2.setDaemon(true);

        thread1.start();
        thread2.start();
    }

}


