package com.peng.c_thread;

public class MyTicket implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100L);
            } catch ( InterruptedException e) {
                throw new RuntimeException(e);
            }
            method();
        }
    }
    public synchronized void method() {
        if ( ticket > 0) {
            System.out.println( Thread.currentThread().getName() + "正在卖第" + ticket-- + "张票");
        }
    }
}
