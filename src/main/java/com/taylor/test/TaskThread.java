package com.taylor.test;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 20:10
 */
public class TaskThread extends Thread {
    private String input;

    public TaskThread(String input) {
        this.input = input;

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + Test.TestDo.doSome(this.input));
    }
}
