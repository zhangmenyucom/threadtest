package com.thread.daemon;

import sun.applet.Main;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/27 10:19
 */
public class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread thread=new MyThread();
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我离开thread对象也不再打印了，也就是停止了！");
    }

}
