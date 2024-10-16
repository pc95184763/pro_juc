package com.peng.pre;

public class Demo03 {

    public static void main (String[] args ) {
        MyThread3 thread1 = new MyThread3();
        MyThread3 thread2 = new MyThread3();
        thread1.setName("thread----1");

        thread1.start();
        thread2.start();
    }



}




