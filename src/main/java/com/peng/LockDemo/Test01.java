package com.peng.LockDemo;

public class Test01 {
    public static void main(String[] args) {
        DieLock dieLock1 = new DieLock(true);
        DieLock dieLock2 = new DieLock(false );

        Thread t1 = new Thread(dieLock1);
        Thread t2 = new Thread(dieLock2);

        t1.start();
        t2.start();
    }

}
