package com.taylor.test;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/12 15:01
 */
public class Consumer extends Thread {

    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            product.remove();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Product product = new Product();
        Producer p1 = new Producer(product);
        Producer p2 = new Producer(product);
        Producer p3 = new Producer(product);
        Consumer c = new Consumer(product);
        p1.start();
        p2.start();
        p3.start();
        c.start();
    }

}
