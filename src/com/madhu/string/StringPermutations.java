package com.madhu.string;

import java.util.Scanner;

public class StringPermutations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		char[] inputChars = input.toCharArray();
		
		permutations(input, 0);
	}

	private static void permutations(String input, int i) {
		//base condition
		if (i == input.length()-1) {
			System.out.println(input.toString());
		}
		for (int j = i; j < input.length(); j++) {
//			if (i+1 < input.length()) {
				input = swap(input, i, j);
				permutations(input, i+1);
//			}
		}
	}

	private static String swap(String input, int i, int j) {
		char[] array = input.toCharArray();
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return new String(array);
	}

}
