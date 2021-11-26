package com.javarush.task.task34.task3412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws IOException {
        String str = "qwer,./,./,./tyuiop qwe ,./,./,./mlkn qwe,./,./,./ lkn qwe";
        String str2 = "qwe";
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=reader.readLine())!=null){
            while (str.contains("qwe")) {
                count++;
                str = str.replaceFirst(str2, "");
            }
        }
        System.out.println("Count: " + count);
    }
}
