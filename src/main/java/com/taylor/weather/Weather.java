package com.taylor.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/9 14:54
 */
@Data
@AllArgsConstructor
public class Weather extends Thread {
    private Tempreture tempreture;

    @Override
    public void run() {
        while (true) {
            tempreture.write();
          /*  try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
