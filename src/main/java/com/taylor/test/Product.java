package com.taylor.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaolu.zhang
 * @date: 2017/6/12 15:08
 */
public class Product {
    private List<String> list = new ArrayList<>();

    public synchronized void add() {
        while (list.size() >= 10) {
            try {
                this.wait();
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add("123");
        System.out.println("生产了一个,当前大小为:"+list.size());
        this.notifyAll();
    }

    public synchronized void remove() {
        while (list.isEmpty()) {
            try {
                this.wait();
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove(0);
        System.out.println("消费了一个,当前大小为:"+list.size());
        this.notifyAll();
    }
}
