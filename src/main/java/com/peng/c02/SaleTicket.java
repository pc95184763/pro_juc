package com.peng.c02;

public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread( ()->{
            for (int i = 0 ; i < 30 ; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread( ()->{
            for (int i = 0 ; i <30 ; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread( ()->{
            for (int i = 0 ; i <30 ; i++) {
                ticket.sale();
            }
        }, "C").start();

    }


}
