package com.peng;

public class demo02 {

    public static void main(String[] args) {
//        new Thread( new T2(), "线程2").start();
        new Thread( () -> {
                System.out.println( "Hello World!!!hahah" );

        }, "thread name here!" ).start() ;

    }

}

