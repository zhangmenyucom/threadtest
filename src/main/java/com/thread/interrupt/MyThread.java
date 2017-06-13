package com.thread.interrupt;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/18 11:33
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                System.out.println("i=" + (i + 1));
                if(this.isInterrupted()) {
                    throw new InterruptedException();
                }
            }
            System.out.println("I am out if this if for programe and continue,the thread is not stop ");
        } catch (InterruptedException e) {
            System.out.println(" run into mythread catch");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main match");
            e.printStackTrace();
        }
    }
}
