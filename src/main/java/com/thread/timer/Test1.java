package com.thread.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/6 10:54
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("当前时间为："+new Date());
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.SECOND,1);
        Date runDate=calendar.getTime();
        MyTask task=new MyTask();
        Timer timer=new Timer(false);
        timer.schedule(task,runDate,1000);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();

    }
}
