package com.javarush.task.task32.task3202;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws Exception {
//        String fileName = "testFile.txt";
        String fileName = "\\..\\testFile.txt";
        File file = new File("D:\\temp\\temp2", fileName);
        FileWriter writer = new FileWriter(file);
        System.out.println(file.getAbsolutePath());
        writer.write("Hello world!");
        writer.close();

        if (true) throw new IndexOutOfBoundsException();
        System.out.println("Работа проги после эксепшена");

    }



}
