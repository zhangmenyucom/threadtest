package com.thread.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 10:57
 */
public class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("任务执行了，时间为："+new Date());
    }
}
