package com.visa.prj.core;

import java.util.ArrayList;
import java.util.List;

import com.visa.prj.entity.Fruit;

public class FruitsClient {
	
	static List<Fruit> fruits;
	public static void main(String[] args) {
		fruits = new ArrayList<Fruit>();
		fruits.add(new Fruit("Mango", 61));
		fruits.add(new Fruit("Apple", 60));
		fruits.add(new Fruit("Orange", 35));
		System.out.println(fruits);
		newFruit("Mango");
		System.out.println(fruits);
		newFruit("Apple");
		System.out.println(fruits);
		newFruit("Apple");
		System.out.println(fruits);
		newFruit("Apple");
		System.out.println(fruits);
		newFruit("Pear");
		System.out.println(fruits);
	}
	private static void newFruit(String string) {
		int i;
		for (i = 0; i < fruits.size(); i++) {
			if(fruits.get(i).getName() == string) {
				fruits.get(i).setCount(fruits.get(i).getCount()+1);
				for(int j = i-1; j>=0; j--) {
					if(fruits.get(j).getCount() < fruits.get(i).getCount()) {
						Fruit temp = fruits.get(i);
						fruits.set(i, fruits.get(j));
						fruits.set(j, temp);
					}
				}
				break;
			}
		}
		if(i == fruits.size())
			fruits.add(new Fruit(string, 1));
	}

}
