package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
//		StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\Users\\fynjy\\Downloads\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task32\\task3202\\testFile.log"));
		System.out.println(writer.toString());
	}

	public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
		StringWriter writer = new StringWriter();
		if (is != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String str;
			while ((str = reader.readLine()) != null)
				writer.write(str);
		}
		return writer;
	}
}
