package com.peng.c09;

import com.peng.c02.TUtils;

public class VolatileDemo {
    private static volatile  int num = 1;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println( Thread.currentThread().getName() + " read num: " +num);
//            TUtils.sleep(500);
            while (num == 1) {
//                System.out.print("");
            }
            System.out.println( Thread.currentThread().getName() + " 副线程 read num: " +num);

        }).start();

        TUtils.sleep(500);
        num = 11;
        System.out.println( Thread.currentThread().getName() + "主线程 read num: " +num);


    }



}




