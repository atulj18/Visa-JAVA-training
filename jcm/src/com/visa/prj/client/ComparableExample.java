package com.visa.prj.client;

import java.util.Arrays;

public class ComparableExample {

	public static void main(String[] args) {
		String[] names = {"Lee", "John", "Jacob", "George", "Brad"};
		
//		Arrays.sort(names);
		Arrays.sort(names, (s1, s2) -> s1.length() - s2.length());
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}

}
