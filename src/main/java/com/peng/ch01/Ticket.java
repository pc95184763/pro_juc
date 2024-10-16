package com.peng.ch01;

public class Ticket {
    private int number = 20;

    public synchronized void sale(){
        if ( number <= 0) {
            System.out.println(Thread.currentThread().getName() + "  票已经卖完了");
            return;
        }
        try {
            System.out.println( Thread.currentThread().getName() + " 开始售票, 当前票数: "+ number);
            Thread.sleep(200);
            System.out.println( Thread.currentThread().getName() + "买票售票, 剩余票数: "+ --number );
        } catch ( InterruptedException e) {
            e.printStackTrace();
        }
    }

}
