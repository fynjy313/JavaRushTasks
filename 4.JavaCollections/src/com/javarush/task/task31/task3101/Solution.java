package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		File filePath = new File(args[0]);//путь к директории,
		File source = new File(args[1]);//имя (полный путь) существующего файла, который будет содержать результат.

//		File filePath = new File("D:\\test\\1");
//		File source = new File("D:\\test\\test.txt");

		File destination = new File(source.getParent() + "/allFilesContent.txt");
		if (FileUtils.isExist(destination)) FileUtils.deleteFile(destination);
		if (FileUtils.isExist(source)) FileUtils.renameFile(source, destination);

		ArrayList<File> list = fileTree(filePath);
//		for (File file : list) System.out.println(file.getAbsolutePath());


		if (list.size() > 0) {
			FileOutputStream fos = new FileOutputStream(destination, true);
			FileInputStream fis;
			for (File file : list) {
				fis = new FileInputStream(file);
				while (fis.available() > 0) {
					fos.write(fis.read());
				}
				fos.write("\n".getBytes(StandardCharsets.UTF_8));
				fis.close();
			}
			fos.close();
		}
	}

	public static ArrayList<File> fileTree(File dir) {
		ArrayList<File> fileList = new ArrayList<>();
		if (dir == null || dir.listFiles() == null)
			return fileList;
		for (File file : Objects.requireNonNull(dir.listFiles())) {
			if (file.isFile() && file.length() <= 50) fileList.add(file);
			else fileList.addAll(fileTree(file));
		}
		Collections.sort(fileList);
		return fileList;
	}
}
