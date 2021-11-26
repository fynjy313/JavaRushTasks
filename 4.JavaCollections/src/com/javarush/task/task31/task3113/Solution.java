package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/

public class Solution {
    public static int countFolder = 0, countFiles = 0;
    public static long volumeFolders = 0;
    public static Path path;

    public static void main(String[] args) throws IOException {
        path = readPath();
//        path = Paths.get("D:\\temp");
        if (Files.isRegularFile(path)) System.out.println(path + " - не папка");
        else {
            Files.walkFileTree(path, new MyFileVisitor());
            System.out.println("Всего папок - " + countFolder);
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + volumeFolders);
        }
    }

    public static Path readPath() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Paths.get(reader.readLine());
    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (Files.isDirectory(dir) && dir != path) countFolder++;
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (Files.isRegularFile(file)) countFiles++;
            volumeFolders += attrs.size();
            //System.out.println(file + " размер " + attrs.size());
            return super.visitFile(file, attrs);
        }


    }
}
