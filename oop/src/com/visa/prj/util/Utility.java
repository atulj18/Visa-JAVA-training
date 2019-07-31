package com.visa.prj.util;

public class Utility {
	public static void sort(Comparable[] elmns) {
		for (int i = 0; i < elmns.length; i++) {
			for(int j = i+1; j < elmns.length; j++) {
				if(elmns[i].compareTo(elmns[j]) > 0) {
					Comparable temp = elmns[i];
					elmns[i] = elmns[j];
					elmns[j] = temp;
				}
			}
		}
	}
}
