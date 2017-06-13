package com.taylor.test.stockhole;

import lombok.Data;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/9 14:32
 */
@Data
public class Person extends Thread {
    private String userName;
    private StockHole stockHole;

    public Person(String name,StockHole stockHole) {
        this.userName = name;
        this.stockHole=stockHole;
    }

    @Override
    public void run(){
      this.stockHole.workingThroughStockHole(this.getUserName());
    }


    public static void main(String[] args) {
        StockHole stockHole=new StockHole("五指山");
        Thread threadA=new Person("A",stockHole);
        Thread threadB=new Person("B",stockHole);
        Thread threadC=new Person("C",stockHole);
        Thread threadD=new Person("D",stockHole);
        Thread threadE=new Person("E",stockHole);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
    }
}
