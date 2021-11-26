package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
//        args = new String[]{"D:\\temp\\file.txt", "10", "text"};
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long number = Long.parseLong(args[1]);
            raf.seek(number);
            int length = args[2].length();
            byte[] buffer = new byte[length];
            raf.read(buffer, 0, length);
            String str = new String(buffer);

            raf.seek(raf.length());
            if (args[2].equals(str))
                raf.write("true".getBytes());
            else raf.write("false".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
