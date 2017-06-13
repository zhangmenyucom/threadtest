package com.thread.reentrantreadandwritelock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 10:39
 */
public class ReadThreadA extends Thread {
    private ReadService service;

    public ReadThreadA(ReadService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}
