package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

	public static void main(String[] args) throws IOException {
//		Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
		Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:\\test\\downloadFileDirectory\\"));

		for (String line : Files.readAllLines(passwords)) {
			System.out.println(line);
		}
	}

	public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
		// implement this method
		URL url = new URL(urlString);
		InputStream is = url.openStream();
		Path tempFile = Files.createTempFile("tmp-", ".tmp");
		Path resFile = Paths.get(downloadDirectory + "/qweqweqwe.txt");
		
		Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);

		Files.move(tempFile, resFile, StandardCopyOption.REPLACE_EXISTING);
		return downloadDirectory;

	}
}
