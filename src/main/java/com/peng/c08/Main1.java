package com.peng.c08;




import java.util.List;
import java.util.concurrent.*;

public class Main1 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool2 = Executors.newFixedThreadPool(5);

        try {
          for ( int i = 0 ; i <1000; i ++) {
              threadPool2.execute( ()->{
                  System.out.println( Thread.currentThread().getName() + "开始执行业务逻辑");
                  try {
                      TimeUnit.MILLISECONDS.sleep(50);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }

              });
          }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }




    }

}



