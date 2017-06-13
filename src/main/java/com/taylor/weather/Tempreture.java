package com.taylor.weather;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/9 14:55
 */
@Data
public class Tempreture {
    private static final List<Integer> list = new ArrayList<>();
    public static final ReentrantLock lock = new ReentrantLock();
    public static final Condition conditionRead = lock.newCondition();
    public static final Condition conditionWrite = lock.newCondition();
    public static int countread;
    public static int countwrite;
    public static volatile int  a=1;

    public void read() {
        try {
            lock.lock();
            while (a==1) {
                conditionRead.await();
            }
            countread++;
            System.out.println("当前读取温度为-------------：" + list.size()+",执行次数:"+countread);
            a=1;
            //list.remove(0);
            conditionWrite.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public void write() {
        try {
            lock.lock();
            while (a==0) {
                conditionWrite.await();
            }
            a=0;
            //list.add(1);
            countwrite++;
            System.out.println("当前检测温度为++++++++++++：" + list.size()+",执行次数:"+countwrite);
            conditionRead.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

}
