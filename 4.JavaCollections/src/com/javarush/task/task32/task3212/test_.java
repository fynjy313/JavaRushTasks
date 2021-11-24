package com.javarush.task.task32.task3212;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test_ {
	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("D:\\test\\allFilesContent.txt", "rw");
		file.seek(8);
		System.out.println(file.readLine());

		File myFile = new File("D:\\test\\allFilesContent.txt");
		Path pathToMyFile = myFile.toPath(); //получаем переменную типа Path из переменной типа File
		Stream<String> stringStream = Files.lines(pathToMyFile); //кому интересно, выясняйте сами, что тут происходит =)
		List<String> fileAsList = stringStream.collect(Collectors.toList()); //превращаем Stream<String> в список(List)
		String line10000 = fileAsList.get(9999); //первая строка файла это нулевой элемент списка строк

		Reader reader = new StringReader("text");
		Writer writer = new StringWriter();
		writer.write("text1");
		String out = writer.toString();



	}
}
