package com.urise.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    private static int counter;
    private static final int TREADS_NUMBER = 10000;


    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
            }
        };
        thread0.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState());
        }).start();

        System.out.println(thread0.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(TREADS_NUMBER);

        for(int i=0; i<TREADS_NUMBER; i++){
            Thread thread = new Thread(()-> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }

            });
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(counter);

        System.out.println("there is deadlock: ");

        new Thread(() -> {
            threadTodead(lock1,lock2);
        }).start();

        new Thread(() -> {
            threadTodead(lock2,lock1);
        }).start();
    }

    private synchronized void inc() {
        counter++;
    }

    private static void threadTodead(Object lock1,Object lock2) {
        synchronized (lock1) {
            System.out.println("threadDead1 locking LOCK_1");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println("threadDead1 locking LOCK_2");
            synchronized (lock2) {
                System.out.println("success");
            }
        }
    }
}
