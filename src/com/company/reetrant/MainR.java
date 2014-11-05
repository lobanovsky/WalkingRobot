package com.company.reetrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by evgeny on 11/08/14.
 */
public class MainR {


    public static void main(String[] args) {
        RobotR robotR = new RobotR();
        WorkerR workerR = new WorkerR(robotR);
        WorkerL workerL = new WorkerL(robotR);

//        ExecutorService es = Executors.newFixedThreadPool(2);
//        es.submit(workerL);
//        es.submit(workerR);
//        es.shutdown();

        Thread t1 = new Thread(workerR);
        Thread t2 = new Thread(workerL);
        t1.start();
        t2.start();


    }

    private static class WorkerR implements Runnable {

        private RobotR robotR;

        private WorkerR(RobotR robotR) {
            this.robotR = robotR;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.print(Thread.currentThread().getName());
                    robotR.doRight();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class WorkerL implements Runnable {

        private RobotR robotR;

        private WorkerL(RobotR robotR) {
            this.robotR = robotR;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.print(Thread.currentThread().getName());
                    robotR.doLeft();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
