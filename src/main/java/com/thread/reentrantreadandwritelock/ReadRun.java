package com.thread.reentrantreadandwritelock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 10:37
 */
public class ReadRun {
    public static void main(String[] args) {
        ReadService service = new ReadService();
        ReadThreadA a = new ReadThreadA(service);
        a.setName("A");
        ReadThreadB b = new ReadThreadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}
