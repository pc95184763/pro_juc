package com.peng.c10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo1 {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(5);

        Runnable runnable = () -> {
            System.out.println( Thread.currentThread().getName() + " is working ");
        };
        CompletableFuture.runAsync(runnable, pool );



    }

}
