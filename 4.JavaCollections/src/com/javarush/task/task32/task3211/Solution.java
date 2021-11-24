package com.javarush.task.task32.task3211;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
	public static void main(String... args) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(new String("test string"));
		oos.flush();
		System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

	}

	public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] calcMD5 = messageDigest.digest(byteArrayOutputStream.toByteArray());
//https://coderoad.ru/2817752/Java-%D0%BA%D0%BE%D0%B4-%D0%B4%D0%BB%D1%8F-%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F-%D0%B1%D0%B0%D0%B9%D1%82%D0%B0-%D0%B2-%D1%88%D0%B5%D1%81%D1%82%D0%BD%D0%B0%D0%B4%D1%86%D0%B0%D1%82%D0%B5%D1%80%D0%B8%D1%87%D0%BD%D1%8B%D0%B9

		StringBuilder sb = new StringBuilder();
		for (byte e : calcMD5) {
			sb.append(String.format("%02x", e & 0xff));
		}
		return sb.toString().equals(md5);
	}
}
