package com.taylor.test;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 19:56
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("begin" + (System.currentTimeMillis() / 1000));
        for (int i = 0; i < 10; i++) {
            String input = i + "";
            new TaskThread(input).start();
        }
    }

    static class TestDo {
        public  static synchronized String doSome(String input) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input + ":" + (System.currentTimeMillis() / 1000);
        }
    }
}
