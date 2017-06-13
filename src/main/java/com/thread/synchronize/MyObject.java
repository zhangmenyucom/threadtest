package com.thread.synchronize;

import com.thread.suspend.MyThread;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/27 10:49
 */
@Data
public class MyObject {
    private int i = 0;

    public synchronized void methodA() {
        System.out.println("进入methodA");
        this.i++;
        System.out.println("methodA i=" + i);
    }

    public  void methodB() {
        System.out.println("进入methodB");
        this.i++;
        System.out.println("methodB i=" + i);
    }

    public static void main(String[] args) {
        AtomicInteger a=new AtomicInteger(1);
        MyObject myObject = new MyObject();
        MyThreadA myThreadA = new MyThreadA(myObject);
        MyThreadB myThreadB = new MyThreadB(myObject);
        myThreadA.start();
        myThreadB.start();
    }
}
