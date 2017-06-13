package com.taylor.test;

import lombok.Data;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/12 15:45
 */
@Data
public class PrintTaskB extends Thread {

    private Task task;

    public PrintTaskB(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        while (true) {
            task.printB();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Task task=new Task();
        PrintTaskA a=new PrintTaskA(task);
        PrintTaskB b=new PrintTaskB(task);
        a.start();
        b.start();
    }

}
