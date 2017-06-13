package com.taylor.test;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/12 15:50
 */
public class Task {
    public static volatile int a;

    public synchronized void printA() {
        while (a == 1) {
            try {
                this.wait();
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A-----");
        a = 1;
        this.notifyAll();
    }

    public synchronized void printB() {
        while (a == 0) {
            try {
                this.wait();
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B+++++");
        a = 0;
        this.notifyAll();
    }
}
