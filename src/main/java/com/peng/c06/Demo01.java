package com.peng.c06;

import java.util.concurrent.*;

public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

       MyCallableThread myCallableThread = new MyCallableThread();
       FutureTask task = new FutureTask( myCallableThread);
       new Thread(task, "MyCallableThread").start();
       System.out.println( task.get(100, TimeUnit.MILLISECONDS) );

    }
}



class MyCallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        int i;
        for (i = 0; i < 10; i++) {
            Thread.sleep(300);
            System.out.println(Thread.currentThread().getName() + " 执行了！" + i);
        }
        return i;
    }
}


