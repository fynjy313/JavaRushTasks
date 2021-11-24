package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
	public static List<String> getFileTree(String root) throws IOException {
		List<String> allFiles = new ArrayList<>();
		Queue<File> dirs = new LinkedList<>();
		dirs.add(new File(root));
		while (!dirs.isEmpty()) {
			for (File file : Objects.requireNonNull(dirs.poll().listFiles())) {
				if (file.isDirectory())
					dirs.add(file);
				else if (file.isFile())
					allFiles.add(file.getAbsolutePath());
			}
		}
		return allFiles;
	}

	public static void main(String[] args) throws IOException {
//		List<String> list = getFileTree("D:\\test\\");
//		for (String s : list) System.out.println(s);

	}
}
