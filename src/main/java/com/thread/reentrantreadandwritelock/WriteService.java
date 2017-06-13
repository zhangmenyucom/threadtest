package com.thread.reentrantreadandwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 10:33
 */
public class WriteService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("get write lock" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }
}
