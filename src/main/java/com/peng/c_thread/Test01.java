package com.peng.c_thread;

public class Test01 {

    public static void main(String[] args) {
        MyTicket ticket = new MyTicket();
        Thread t1 = new Thread( ticket , "t1");
        Thread t2 = new Thread( ticket , "t2");
        Thread t3 = new Thread( ticket , "t3");


        t1.start();
        t2.start();
        t3.start();
    }


}
