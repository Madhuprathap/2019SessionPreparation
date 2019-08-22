package com.madhu.generics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class Test<T extends Num> {
	T i;
	
	public Test(T n) {
		i = n;
	}
	
	public void print() {
		i.print();
	}
	
	public static void main(String[] args) {
//		Integer.parseInt(null);
		
		Properties prop = new Properties();
		prop.setProperty("Madhu", "Madhu");
		String t = prop.getProperty("Madhu");
		System.out.println(t);
		
		System.out.println(prop.containsKey("Madhu"));
		System.out.println(prop.containsKey("Ravi"));
		
		String protocol = null;
		String hostname = null;
		int portNumber = 0;
		try {
			URL url = new URL(protocol , hostname, portNumber, "");
		} catch (MalformedURLException | NullPointerException e) {
			System.out.println("exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		List l1 = new ArrayList();
		l1.add("ad");
		l1.add(12);
		System.out.println(l1.size());
		
		List<String> l2 = new ArrayList<>();
		l2.add("madhu");
//		l2.add(12);  // compilation error
		
		List<Num> l3 = new ArrayList<>();
		l3.add(new EvenNum(2));
		l3.add(new Num(0));
		l3.add(new OddNum(1));
		
		// <x extends Num> -> Num and its subclasses allowed
		Test t1 = new Test<Num>(new Num(1));
		t1.print();
		
		Test t2 = new Test<EvenNum>(new EvenNum(2));
		t2.print();
		
		// not allowed as Sting is not sub class of Num
//		Test t3 = new Test<String>(new EvenNum(2));
		
		// < ? extends Num> -> upper bound 
		// used to perform the logic
		List<Num> l4 = new ArrayList<Num>();
		l4.add(new Num(1));
		l4.add(new EvenNum(2));
		print(l4);
		
		l4 = new ArrayList<Num>();
		l4.add(new Num(1));
		l4.add(new EvenNum(2));
		l4.add(new OddNum(1));
		supercheck(l4);
		
		List<EvenNum> l5 = new ArrayList<EvenNum>();
		l5.add(new EvenNum(1));
		l5.add(new EvenNum(2));
		print(l5);
		
		List l6 = new ArrayList();
		l6.add(new Num(1));
		l6.add(new EvenNum(2));
		print(l6);
		
		// not allowed to store values
//		List<? extends Num> l7 =  new ArrayList<>();
//		l7.add(new Num(1));
		
		// <? super Num> -> lower Bound
		// Used to store Num and its sub class objects in the collection
		List<? super Num> l9 = new ArrayList<Num>();
		l9.add(new Num(0));
		l9.add(new EvenNum(2));
		l9.add(new OddNum(1));
		
		List<Integer> integers = Arrays.asList(0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1);
		int count = count(integers, 1);
		System.out.println("#occurrences of 1s: " + count);
		List<Double> doubles = Arrays.asList(0.0,1.1);
		count = count(doubles, 1.1);
		System.out.println("#occurrences of 1s: " + count);
		
		List<Number> number = Arrays.<Number>asList(0, 1.1, 1.2f);
		count = count(number, 1);
		List<Number> test = Arrays.asList(0,1.1);
		count = count(test, 1);
		
		List<Integer> ints = Arrays.asList(0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1);
		double c = sumNumbers(ints, 1);
		System.out.println("#occurrences of 1s: " + c);
	}

	private static <A extends Num> void print(List<A> l) {
		for (Num num : l){
			num.print();
		}
	}
	
	/*private static void print(List<? extends Num> l) {
		for (Num num : l){
			num.print();
		}
	}*/
	
	public static <X extends Number> int count(Collection<X> col, X item) {
		return 0;
	    // code...
	}
	
	private static void supercheck(List<? super EvenNum> l) {
		System.out.println("super chek");
		for (Object num : l){
			((Num)num).print();
		}
		System.out.println("super chek");
	}
	
	public static <T extends Number> double sumNumbers(Collection<T> numbers, T n) {
	    numbers.add(n);
	    return count(numbers, n);
	}
}

