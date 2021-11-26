package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
//        args = new String[]{"D:\\temp\\file.txt", "5", "text"};
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long length = raf.length();
            long number = Long.parseLong(args[1]);

//            if (length > 5)
//                raf.seek(number);
//            else raf.seek(length);

            number = number > length ? length : number;
//            number = Math.min(number, length);
            raf.seek(number);

            raf.write(args[2].getBytes(StandardCharsets.UTF_8));
//            raf.write(args[2].getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//try(
//    RandomAccessFile raf = new RandomAccessFile(args[0], "rw"))
//
//    {
//        long number = Long.parseLong(args[1]);
//        long length = raf.length();
//        number = number > length ? length : number;
//        raf.seek(number);
//        raf.write(args[2].getBytes());
//    } catch(
//    IOException e)
//
//    {
//        e.printStackTrace();
//    }
}