package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);


    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<? extends Animal> set = new HashSet<>();
        List<Path> files = new ArrayList<>();

        try {
            files = Files.walk(Paths.get("pathToAnimals"))
                    .filter(Files::isRegularFile)
                    .collect((Collectors.toList()));
//            List<byte[]> list = loadFileAsBytes(files);
//            for (byte[] bytes : list) {
//
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

//    public static List<byte[]> loadFileAsBytes(List<Path> files) throws IOException {
//        byte[] b;
//        List<byte[]> bytes = new ArrayList<>(files.size());
//        FileInputStream fileInputStream = null;
//        for (Path file : files) {
//            b = new byte[(int) file.toFile().length()];
//            fileInputStream = new FileInputStream(file.toFile());
//            fileInputStream.read(b, 0, (int) file.toFile().length());
//            bytes.add(b);
//        }
//        return bytes;
//    }
}
