package com.peng.c02;

import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockDemo2 {
    private ReentrantLock lock = new ReentrantLock();

    public void a() {
        lock.lock();
        this.b();
        System.out.println("--a--!");
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("--b--!");
        lock.unlock();
    }

    public static void main(String[] args) {
        new ReentrantLockDemo2().a();
    }
}
