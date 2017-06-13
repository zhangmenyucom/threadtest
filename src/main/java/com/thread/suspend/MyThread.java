package com.thread.suspend;

import lombok.Data;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/18 15:18
 */
@Data
public class MyThread extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}
