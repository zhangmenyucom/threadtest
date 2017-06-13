package com.thread.piped;

import lombok.Builder;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author xiaolu.zhang
 * @date: 2017/6/5 15:07
 */
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
