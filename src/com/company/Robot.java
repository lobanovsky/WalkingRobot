package com.company;


public class Robot {

    private boolean ready;


    public synchronized void doLeft() throws InterruptedException {
        while (!ready) wait();
        System.out.println("do left");
        ready = false;
        notifyAll();
    }


    public synchronized void doRight() throws InterruptedException {
        while (ready) wait();
        System.out.println("do right");
        ready = true;
        notifyAll();
    }

}
