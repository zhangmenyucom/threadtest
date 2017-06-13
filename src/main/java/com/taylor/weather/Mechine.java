package com.taylor.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/9 15:35
 */
@Data
@AllArgsConstructor
public class Mechine extends Thread {

    private Tempreture tempreture;

    @Override
    public void run() {
        while (true) {
            tempreture.read();
           /* try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }


    public static void main(String... args) {
        Tempreture tempreture = new Tempreture();
        Weather weather = new Weather(tempreture);
        Mechine mechine = new Mechine(tempreture);
        weather.start();
        mechine.start();
    }
}
