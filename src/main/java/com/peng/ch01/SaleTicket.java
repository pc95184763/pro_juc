package com.peng.ch01;

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread( ()-> {
            for (int i = 0; i < 21; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread( ()->{
            for (int i = 0 ; i <21 ; i++) {
                ticket.sale();
            }

        },"B").start();

        new Thread( ()->{
            for (int i = 0; i <21 ; i++) {
                ticket.sale();
            }
        }, "C").start();

    }


}
