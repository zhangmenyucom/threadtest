package com.taylor.test.stockhole;

import lombok.Data;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/9 14:37
 */
@Data
public class StockHole {
    private String name;

    public StockHole(String name) {
        this.name = name;
    }

    public synchronized  void workingThroughStockHole(String username){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(username+"通过了山洞"+this.getName());
    }
}
