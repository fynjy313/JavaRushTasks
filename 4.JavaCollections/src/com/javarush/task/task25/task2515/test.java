package com.javarush.task.task25.task2515;

public class test {
	private static final char[][] matrix = {
			{65, 66, 67, 68, 69, 70},
			{71, 72, 73, 74, 75, 76}
	};

	public static void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
		print();
		System.out.print("-----------");
		matrix[0][0]="F".charAt(0);
		System.out.println(matrix[0][0]);
		System.out.println((int)(Math.random()*10));
	}
}
