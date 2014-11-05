package com.company;

/**
 * Created by evgeny on 11/08/14.
 */
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
