package com.peng.c09;

import javax.xml.crypto.Data;

public class VolatileAtomicDemo {
    public static void main(String[] args) {
        DataOne dataOne = new DataOne();

        for (int i = 0; i <1000; i++) {
            new Thread( ()->{
                System.out.println("dataOne.incr() = " + dataOne.incr());
            }).start();
        }
    }
}

class DataOne {
    private Integer number = 0;

    public  Integer incr() {
        return ++number;
    }
}
