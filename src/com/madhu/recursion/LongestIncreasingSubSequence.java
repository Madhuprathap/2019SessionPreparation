package com.madhu.recursion;

public class LongestIncreasingSubSequence {
	static int max_overall = 1;

	public static void main(String[] args) {
		int[] input = {2, 4, 6, 1, 3, 11};
		int length = LIS(input, input.length);
		System.out.println("LIS length: " + length);
	}

	private static int LIS(int[] input, int length) {
		// base condition
		if (length == 1) {
			return 1;
		}
		int res, max_lis = 1;
		for (int i = 1; i < length; i++) {
			res = LIS(input, i);
			// current element is greater than the element in the loop
			if (input[length - 1] > input [i-1] && res +1 > max_lis) {
				max_lis = res + 1;
			}
		}
		if (max_lis > max_overall) {
			max_overall = max_lis;
		}
		return max_lis;
	}

}
