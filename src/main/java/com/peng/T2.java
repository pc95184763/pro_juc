package com.peng;

public class T2 implements Runnable {

    public void run(){
        System.out.println( Thread.currentThread().getName() + "  Runnable..." );
    }
}
