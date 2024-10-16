package com.peng.pre2;

public class MyTicket1 implements Runnable {

    int ticket = 100;
    Object obj = new Object();

    public void run() {
        while ( true) {
            try {
                Thread.sleep(100L);
            } catch ( InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized ( obj ) {
                if ( ticket > 0) {
                    System.out.println( Thread.currentThread().getName() + "买了第..." + ticket +" 张票" );
                    ticket--;
                }
            }
        }
    }

}







