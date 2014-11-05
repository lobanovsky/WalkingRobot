package com.company;


/*
сделать
1. одним потоком
2. сделать редом и врайтом локом
3. сделать без синхронизации объекта
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {

        final Robot robot = new Robot();

        Runnable runLeft = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        robot.doLeft();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Runnable runRight = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        robot.doRight();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(runLeft);
        Thread t2 = new Thread(runRight);

        t1.start();
        t2.start();
    }
}
