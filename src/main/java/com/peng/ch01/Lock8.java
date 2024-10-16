package com.peng.ch01;

public class Lock8 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread ( ()->{
          phone.sendSMS();
        }).start() ;

        new Thread( ()->{
            phone.sendEmail();
        }).start();
    }

}

class Phone {
    public synchronized void sendSMS() {
        System.out.println("sendSMS");
    }
    public synchronized void sendEmail() {
        System.out.println("sendEmail");
    }
    public void hello(){
        System.out.println("Hello ");
    }

}

