package com.thread.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/5 18:51
 */
public class ConditionSort {

    private static volatile int nextPrintWho = 1;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread threadA = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lock();
                        while (nextPrintWho != 1) {
                            conditionA.await();
                        }
                        for (int i = 0; i < 3; i++) {
                            System.out.println("ThreadA " + (i + 1));
                        }
                        nextPrintWho = 2;
                        conditionB.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lock();
                        while (nextPrintWho != 2) {
                            conditionB.await();
                        }
                        for (int i = 0; i < 3; i++) {
                            System.out.println("ThreadB " + (i + 1));
                        }
                        nextPrintWho = 3;
                        conditionC.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        Thread threadC = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lock();
                        while (nextPrintWho != 3) {
                            conditionC.await();
                        }
                        for (int i = 0; i < 3; i++) {
                            System.out.println("ThreadC " + (i + 1));
                        }
                        nextPrintWho = 1;
                        conditionA.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();
/*
        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];

        for (int i = 0; i < 5; i++) {
            aArray[i] = new Thread(threadA);
            bArray[i] = new Thread(threadB);
            cArray[i] = new Thread(threadC);
            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }*/
    }
}
