package com.visa.prj.util;

public class ArrayUtil {
	public static int getSum(int[] elmns) {
		int sum = 0;
		for (int i = 0; i<elmns.length; i++) {
			sum += elmns[i];
		}
		return sum;
	}
	public static int getCount(int[] elmns, int x) {
		int count = 0;
		for (int i = 0; i<elmns.length; i++) {
			if(elmns[i] == x)
				count++;
		}
		return count;
	}
	public static void sort(int[] elmns) {
		for (int i = 0; i<elmns.length; i++) {
			for(int j = i+1; j<elmns.length; j++) {
				if(elmns[j] < elmns[i]) {
					int temp = elmns[i];
					elmns[i] = elmns[j];
					elmns[j] = temp;
				}
			}
		}
	}
}
