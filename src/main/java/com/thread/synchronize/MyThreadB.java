package com.thread.synchronize;

import lombok.Data;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/27 10:52
 */
@Data
public class MyThreadB extends Thread {
    private MyObject myObject;

    public MyThreadB(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        while (true) {
            myObject.methodB();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
