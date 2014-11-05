package com.company.reetrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RobotR {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.writeLock();

    public void doLeft() {
        try {
            readLock.lock();
            System.out.println("do left");
        } finally {
            readLock.unlock();
        }
    }

    public void doRight() {
        try {
            readLock.lock();
            System.out.println("do right");
        } finally {
            readLock.unlock();
        }
    }
}
