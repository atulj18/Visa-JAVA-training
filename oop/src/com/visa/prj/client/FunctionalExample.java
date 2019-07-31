package com.visa.prj.client;

@FunctionalInterface
interface Computation{
	int compute(int x, int y); //Only one function is allowed
}
public class FunctionalExample {

	public static void main(String[] args) {
		Computation c1 = new Computation() { //Anonymous Class
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};
		doTask(c1, 4, 5);
		Computation c2 = new Computation() { //Anonymous class
			@Override
			public int compute(int x, int y) {
				return x - y;
			}
		};
		doTask(c2, 4, 5);
		
		// Lambda is short cut for Anonymous class only for functional interface
		Computation c3 = (int x, int y) -> {
			return x*y;
		};
		doTask(c3, 4, 5);
		
		Computation c4 = (x, y) -> {
			return x*y;
		};
		doTask(c4, 4, 5);
		
		Computation c5 = (x, y) -> x*y; // For single statement
		doTask(c5, 4, 5);
	}

	private static void doTask(Computation c1, int i, int j) {
		System.out.println(c1.compute(i, j));
	}
	

}
