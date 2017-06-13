package com.taylor.test;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/12 15:01
 */
public class Producer extends Thread {

    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            product.add();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}