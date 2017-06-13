package com.thread.suspend;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/18 15:20
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(5000);

            //A
            myThread.suspend();
            System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread.getI());
            Thread.sleep(5000);
            System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread.getI());

            //B
            myThread.resume();
            Thread.sleep(5000);

            //C
            myThread.suspend();
            System.out.println("B= " + System.currentTimeMillis() + " i=" + myThread.getI());
            Thread.sleep(5000);
            System.out.println("B= " + System.currentTimeMillis() + " i=" + myThread.getI());
            myThread.resume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
