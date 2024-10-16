package com.peng.c04;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Demo02 {

    public static void main(String[] args) {
        List<Integer> list = new Vector<>();

        for (int i = 0; i < 100; i++) {
            new Thread( ()->{
               list.add( new Random().nextInt(10) );
               System.out.println( list );
            });
        }
    }

}
