package com.thread.stop;


import lombok.Data;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/5/18 14:43
 */
@Data
public class SynchronizedObject {
    private String username = "a";
    private String passwords = "aa";

    public synchronized void printString(String username, String passwords) {
        try {
            this.username = username;
            this.passwords = passwords;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
