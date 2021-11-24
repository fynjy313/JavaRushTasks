package com.javarush.task.task22.task2213;

import java.util.ArrayList;

@Deprecated
public class test_matrix {
	public static int[][] matrix = {
			{1, 1, 0},
			{0, 0, 0},
			{1, 1, 1}};


	public static void main(String[] args) {
		printMatrix(matrix);

		ArrayList<int[]> list2 = new ArrayList<>();

		int sum = 0;

		System.out.println("----------- new list");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += matrix[i][j];
			}
			if (sum < 3) list2.add(matrix[i]);
			//else matrix[i] = null;
			sum = 0;
		}
		while (list2.size() < 3) {
			int[] zeroLine = new int[3];
			list2.add(0, zeroLine);
		}

		for (int[] ints : list2) {
			printLine(ints);
			System.out.println();
		}

		System.out.println("----------- new matrix");

		matrix = list2.toArray(new int[3][3]);
		printMatrix(matrix);

	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printLine(int[] line) {
		for (int i : line) {
			System.out.print(i + " ");
		}
	}
}
