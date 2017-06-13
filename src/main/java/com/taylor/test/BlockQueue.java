package com.taylor.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 20:36
 */
public class BlockQueue {

    private BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();

    public void test() {
        for (int i = 0; i < 100; i++) {
            blockingQueue.add("test" + i);
        }
        try {
            while (true) {
                System.out.println(blockingQueue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BlockQueue().test();
    }
}
