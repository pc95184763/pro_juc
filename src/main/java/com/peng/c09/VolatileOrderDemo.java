package com.peng.c09;

public class VolatileOrderDemo {


    static volatile int  a,b;

    static int x,y;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            a = b= x= y = 0;

            Thread thread1 = new Thread( ()->{
                a = 1;
                x = b;
            },"");

            Thread thread2  =new Thread ( ()->{
                b = 1;
                y = a;
            }, "");

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println("第"+i +"次打印" + x + ", y=" + y);
            if (x == 0 && y == 0) {
                break;
            }
        }
    }


}













