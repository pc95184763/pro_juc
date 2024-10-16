package com.peng.c02;

public class TUtils {
    public static void sleep(long time ) {
        try {
            Thread.sleep( time );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
