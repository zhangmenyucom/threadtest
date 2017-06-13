package com.thread.stop;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/18 14:48
 */
public class MyThread extends Thread {
    private SynchronizedObject synchronizedObject;
    public MyThread(SynchronizedObject synchronizedObject){
        this.synchronizedObject=synchronizedObject;
    }
    @Override
    public void run(){
        synchronizedObject.printString("b","bb");
    }
}
