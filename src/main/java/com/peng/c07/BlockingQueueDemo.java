package com.peng.c07;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BlockingQueueDemo {

    public static void main( String[] args ) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println( queue.add("aaa") );
        System.out.println( queue.add("bbb") );
        queue.add("ccc") ;

    }

}


