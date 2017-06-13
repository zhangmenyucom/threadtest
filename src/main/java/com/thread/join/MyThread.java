package com.thread.join;

import static java.lang.Math.random;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/5 16:09
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            int secondValue = (int)(random() * 1000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
