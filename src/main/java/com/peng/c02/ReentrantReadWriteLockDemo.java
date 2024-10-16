package com.peng.c02;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    public static void main ( String[] args ) {

        MyCache cache = new MyCache();

        for (int i = 1; i <= 5; i++) {
            String num = String.valueOf(i);
            // 开启5个写线程
            new Thread(()->{
                cache.put(num, num);
            }, num).start();
        }

        for (int i = 1; i <= 5; i++) {
            String num = String.valueOf(i);
            // 开启5个读线程
            new Thread(()->{
                cache.get(num);
            }, num).start();
        }

    }

}

class MyCache {

    private Map<String, String> cache = new HashMap<>();
    public final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String val) {
        readWriteLock.writeLock().lock();
        String name = Thread.currentThread().getName();

        try {
            System.out.println(name + " 准备写: "+val );
            TUtils.sleep(300);
            cache.put( key, val );
        } finally {
            readWriteLock.writeLock().unlock();
        }

        System.out.println(name + "写完： "+ val);
    }


    public void get(String key){

        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 开始读出！");
            Thread.sleep(300);
            String value = cache.get(key);
            System.out.println(Thread.currentThread().getName() + " 读出成功！" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }


}

