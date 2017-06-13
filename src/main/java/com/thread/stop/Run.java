package com.thread.stop;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/18 14:50
 */
public class Run {
    public static void main(String[] args) {
        try {
            SynchronizedObject synchronizedObject=new SynchronizedObject();
            MyThread thread=new MyThread(synchronizedObject);
            thread.start();
            Thread.sleep(1);
            thread.stop();
            System.out.println(synchronizedObject.getUsername()+" "+synchronizedObject.getPasswords());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
