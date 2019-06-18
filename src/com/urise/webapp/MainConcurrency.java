package com.urise.webapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainConcurrency {
    private static int counter;
    private static final int TREADS_NUMBER = 10000;
    private final AtomicInteger atomicCounter = new AtomicInteger();
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    private static Lock lock = new ReentrantLock();

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
        CountDownLatch latch = new CountDownLatch(TREADS_NUMBER);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        CompletionService completionService = new ExecutorCompletionService(executorService);

//        List<Thread> threads = new ArrayList<>(TREADS_NUMBER);

        for (int i = 0; i < TREADS_NUMBER; i++) {
            Future<Integer> future = executorService.submit(() ->
//            Thread thread = new Thread(() ->
            {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                    System.out.println(DATE_FORMAT.get().format(new Date()));
                }
                latch.countDown();
                return 5;
            });
//            completionService.poll();
//            System.out.println(future.isDone());
//            System.out.println(future.get());
//            thread.start();
//            threads.add(thread);
        }

//        threads.forEach(thread -> {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        latch.await();
        executorService.shutdown();
//        System.out.println(counter);
        System.out.println(mainConcurrency.atomicCounter.get());

        System.out.println("there is deadlock: ");

        new Thread(() -> {
            threadTodead(lock1, lock2);
        }).start();

        new Thread(() -> {
            threadTodead(lock2, lock1);
        }).start();

    }

    private void inc() {
//        lock.lock();
//        try {
        atomicCounter.incrementAndGet();
            counter++;
//        } finally {
//            lock.unlock();
//        }
    }

    private static void threadTodead(Object lock1, Object lock2) {
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
