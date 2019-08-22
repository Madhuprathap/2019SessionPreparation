package com.madhu.string;

import java.util.Scanner;

public class Subsets {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		subsets(input, input.length(), 0, "");
	}

	private static void subsets(String input, int length, int i, String curr) {
		//base condition
		if (i == length) {
			System.out.println(curr);
			return;
		}
		if (!curr.equals("")) {
			System.out.println(curr);
		}
		for (int j = i; j < length; j++) {
			char tmp = input.charAt(j);
			curr += tmp;
			subsets(input, length, j+1, curr);
			
			//back tracking
			curr = curr.substring(0, curr.length()-1);
		}
	}
}
