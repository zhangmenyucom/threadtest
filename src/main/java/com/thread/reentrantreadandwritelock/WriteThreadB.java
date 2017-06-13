package com.thread.reentrantreadandwritelock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 10:39
 */
public class WriteThreadB extends Thread {
    private WriteService service;

    public WriteThreadB(WriteService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
