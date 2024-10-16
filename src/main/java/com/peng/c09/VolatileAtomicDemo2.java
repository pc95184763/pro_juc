package com.peng.c09;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicDemo2 {

    public static void main(String[] args) {
        DataOne2 dataOne = new DataOne2();

        for (int i = 0; i <1000; i++) {
            new Thread( ()->{
                System.out.println("dataOne.incr() = " + dataOne.incr());
            }).start();
        }
    }

}

class DataOne2 {
    private AtomicInteger number = new AtomicInteger(0);

    public  Integer incr() {
        return number.incrementAndGet();
    }

}
