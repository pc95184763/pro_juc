package com.peng;

public class T1 extends Thread {
    @Override
    public void run (){
        System.out.println("Thread...");
        super.run();
    }

}
