package com.opentext;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


interface Register {
	void addAttendance(int[] a);
	void changeAttendance(int id, char c);
	void reduceRegister(int limit);
	void personalAttendance(int id);
	int maxAttendance();
}

class CustomRegister implements Register{
	Map<Integer, Integer>  register;
	
	public CustomRegister() {
		register = new HashMap<Integer, Integer>();
	}

	@Override
	public void addAttendance(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (register.containsKey(a[i])) {
				register.put(a[i], register.get(a[i])+1);
			} else {
				register.put(a[i], 1);
			}
		}
	}

	@Override
	public void changeAttendance(int id, char c) {
		if(c == 'A') {
			register.put(id, register.get(id)-1);
			System.out.println("Attendance of the Student with id:" + id + "has been reduced by one");
		} else if (c == 'P') {
			register.put(id, register.get(id)+1);
			System.out.println("Attendance of the Student with id:" + id + "has been increased by one");
		}
	}

	@Override
	public void reduceRegister(int limit) {
		System.out.println("Removing students with less attendance");
		Set<Entry<Integer, Integer>> entries = register.entrySet();
		for (Entry<Integer, Integer> entry : entries) {
			if (entry.getValue() < limit) {
				register.remove(entry.getKey());
			}
		}
	}

	@Override
	public void personalAttendance(int id) {
		if (register.containsKey(id)) {
			System.out.println("The Attendance of the student with id:" + id + " is:" + register.get(id));
		} else {
			System.out.println("The student with id:" + id + "has been removed due to low attendance");
		}
		
	}

	@Override
	public int maxAttendance() {
		Integer max = Integer.MIN_VALUE;
		Set<Entry<Integer, Integer>> entries = register.entrySet();
		for (Entry<Integer, Integer> entry : entries) {
			if (register.get(entry.getKey()) > max) {
				max = register.get(entry.getKey());
			}
		}
		return max;
	}
	
}

public class One {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  Random rand = new Random(0);

		  int n = Integer.parseInt(sc.nextLine());
		  int[] a = new int[n];
		  for(int i = 0; i < n; i++)
		   a[i] = Integer.parseInt(sc.nextLine());

		  CustomRegister cr = new CustomRegister();
		  cr.addAttendance(a);
		  
		  int m = Integer.parseInt(sc.nextLine());
		   for(int i = 0; i < m; i++){
		   String[] s = sc.nextLine().split(" ");
		   int id = Integer.parseInt(s[0]);
		   char c = s[1].charAt(0);
		   cr.changeAttendance(id,c);
		  }

		  int l = Integer.parseInt(sc.nextLine());
		  cr.reduceRegister(l);

		  int id = Integer.parseInt(sc.nextLine());
		  cr.personalAttendance(id);

		  System.out.println("The maximum attendance is: "+cr.maxAttendance());
	}
	
}