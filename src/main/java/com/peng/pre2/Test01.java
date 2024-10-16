package com.peng.pre2;

public class Test01 {
    public static void main(String[] args) {
        MyTicket1 ticket = new MyTicket1();
        Thread t1 = new Thread(ticket, "t1");
        Thread t2 = new Thread(ticket, "t2");
        Thread t3 = new Thread(ticket, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
