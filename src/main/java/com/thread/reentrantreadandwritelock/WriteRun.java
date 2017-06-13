package com.thread.reentrantreadandwritelock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 10:37
 */
public class WriteRun {
    public static void main(String[] args) {
        WriteService service = new WriteService();
        WriteThreadA a = new WriteThreadA(service);
        a.setName("A");
        WriteThreadB b = new WriteThreadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}
