package com.peng.pre2;

public class MyTicket implements Runnable{
    int ticket = 10;

    @Override
    public  void run(){
        while (true) {
            if ( ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "买了第..." + ticket +" 张票");
                ticket--;
            }
        }
    }

}
