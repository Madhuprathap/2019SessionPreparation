package com.madhu.DP;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int[] input = {2, 4, 6, 1, 3, 11};
		// Base max will be one as each element can be included in
		int[] LIS = Arrays.stream(new int[input.length]).map(n -> 1).toArray();
		
		// DP solution save the re occurring problems solution
		int max = 1;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j] && LIS[j] + 1 > LIS[i]) {
					LIS[i] = LIS[j] + 1;
					if(max < LIS[i]) {
						max = LIS[i];
					}
				}
			}
		}
		
		System.out.println("LIS length: " + max);
	}

}
