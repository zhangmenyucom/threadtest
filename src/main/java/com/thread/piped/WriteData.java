package com.thread.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author xiaolu.zhang
 * @desc:
 * @date: 2017/6/5 15:00
 */
public class WriteData {
    public void writeMethod(PipedOutputStream ouput) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                ouput.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            ouput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
