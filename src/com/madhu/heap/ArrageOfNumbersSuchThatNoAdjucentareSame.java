package com.madhu.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

class Unit implements Comparable<Unit>{
	int num;
	int frequency;
	public Unit(int num, int frequency) {
		super();
		this.num = num;
		this.frequency = frequency;
	}
	@Override
	public int compareTo(Unit o) {
		return Integer.compare(o.frequency, frequency);
	}
	
	@Override
	public int hashCode() {
		return num;
	}
	
	@Override
	public boolean equals(Object obj) {
		return num == ((Unit)obj).num;
	}
}

public class ArrageOfNumbersSuchThatNoAdjucentareSame {
	public static void main(String[] args) {
		ArrageOfNumbersSuchThatNoAdjucentareSame o = new ArrageOfNumbersSuchThatNoAdjucentareSame();
		int[] input = {1, 1, 1, 1, 2, 2, 3, 3};
		PriorityQueue<Unit> queue = new PriorityQueue<Unit>(/*new Comparator<Unit>() {

			@Override
			public int compare(Unit o1, Unit o2) {
				return Integer.compare(o1.frequency,o2.frequency);
			}
		}*/);
		
		int[] count = new int[input.length]; 
        int visited[] = new int[input.length];
        for (int i = 0; i < input.length; i++) 
            count[input[i]]++; 
  
        // Adding high freq elements in descending order 
        for (int i = 0; i < input.length; i++) { 
            int val = input[i]; 
  
            if (count[val] > 0 && visited[val] != 1) 
                queue.add(new Unit(val, count[val])); 
            visited[val] = 1; 
        } 
  
		
		Unit prev = new Unit(-1, -1);
		int[] result = new int[input.length];
		int l = 0;
		while (queue.size() > 0) {
			Unit tmp = queue.poll();
			result[l] = tmp.num;
			tmp.frequency--;
			
			if (prev.frequency > 0) {
				queue.add(prev);
			}
			
			prev = tmp;
			l++;
		}
		
		Arrays.stream(result).forEach(System.out::print);
	}

}
