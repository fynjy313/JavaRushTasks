package com.javarush.task.task31.task3109;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class test_temp {


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\");
//        Files.walkFileTree(path, new myVisitor(path));

        Files.walkFileTree(path, new myVisitor());

    }

    public static class myVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (attrs.isDirectory()) System.out.println("Directory: " + file);
            else if (attrs.isRegularFile()) System.out.println("File: " + file);
            System.out.println(attrs.size() + " bytes");

            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println(exc);
            return FileVisitResult.CONTINUE;
        }
    }

}
