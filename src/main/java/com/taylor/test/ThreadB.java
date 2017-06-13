package com.taylor.test;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 20:44
 */
public class ThreadB extends Thread {
    private int a;
    private int b;



    public synchronized void testB() {
        try {
            if (a == 1) {
                this.wait();
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void testA() {
        try {
            if (b == 1) {
                this.wait();
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadB thread = new ThreadB();
        thread.start();
    }

    @Override
    public void run() {
        testA();
        testB();
    }

}