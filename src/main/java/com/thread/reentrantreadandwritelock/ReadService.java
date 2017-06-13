package com.thread.reentrantreadandwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 10:33
 */
public class ReadService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("get read lock" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }
}
