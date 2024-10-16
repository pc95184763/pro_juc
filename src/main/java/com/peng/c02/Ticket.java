package com.peng.c02;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket {

    private ReentrantLock lock = new ReentrantLock(true);
    private int num = 100;

    public void sale() {
        String name = Thread.currentThread().getName();
        lock.lock();
        if ( num <= 0) {
            System.out.println(name + " 票已售完");
        } else {
            System.out.println(name + " 售出--第" + num + " 张票, 剩下:"+  --num);
        }
        lock.unlock();
    }

}





