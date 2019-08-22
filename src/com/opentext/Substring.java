package com.opentext;

import java.util.HashSet;
import java.util.Set;

public class Substring {
	public static void main(String[] args) {
		String input = "aabcbcdbca";
		int l = shortestSubsing(input);
		System.out.println(l);
	}

	private static int shortestSubsing(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		int distCount = set.size();

		int start = 0, minLength = Integer.MAX_VALUE; 

		int count = 0; 
		int uniqueCharCounts[] = new int[26]; 
		for (int j=0; j < s.length(); j++) 
		{ 
			uniqueCharCounts[s.charAt(j) - 97]++; 

			if (uniqueCharCounts[s.charAt(j) - 97] == 1 ) 
				count++; 

			// if all the characters are matched 
			if (count == distCount) 
			{
				while (uniqueCharCounts[s.charAt(start) - 97] > 1) {
					uniqueCharCounts[s.charAt(start) - 97]--;
					start++; 
				}

				// Update window 
				int windowLength = j - start + 1; 
				if (minLength > windowLength) 
				{
					minLength = windowLength; 
				} 
			} 
		} 

		return minLength; 
	} 

}
