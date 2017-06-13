package com.thread.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/5 18:08
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("threadName=" + Thread.currentThread().getName() + ("--" + (i + 1)));
        }
        lock.unlock();
    }
}
