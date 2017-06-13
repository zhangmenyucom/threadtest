package com.thread.piped;

import com.thread.piped.WriteData;

import java.io.PipedOutputStream;

/**
 * @author xiaolu.zhang
 * @date: 2017/6/5 15:07
 */
public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        this.write = write;
        this.out = out;
    }
    @Override
    public void run() {
        write.writeMethod(out);
    }
}
