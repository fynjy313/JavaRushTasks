package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* 
Шифр Цезаря
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
		System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
	}

	public static String decode(StringReader reader, int key) throws IOException {
		StringBuilder result = new StringBuilder();
		if (reader != null) {
			String str;
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(reader);
			while ((str = br.readLine()) != null)
				sb.append(str);
			str = sb.toString();
			for (int i = 0; i < str.length(); i++) {
				char c = (char) (str.charAt(i) + key);
				result.append(c);
			}
		}
		return result.toString();
	}
}
