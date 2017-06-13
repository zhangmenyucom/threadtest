package com.taylor.test;

import lombok.Data;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/12 15:45
 */
@Data
public class PrintTaskA extends Thread {

    private Task task;

    public PrintTaskA(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
     while(true){
         task.printA();
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
    }

}
