package com.visa.prj.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.entity.Fruit;
import com.visa.prj.entity.Product;

public class XMLConvert {

	public static void main(String[] args) {
		Fruit article = new Fruit("Mango", 120);
		Product p = new Product(20, "iPhone", 20000);
		generateXML(article);
		generateXML(p);
	}

	private static void generateXML(Object obj) {
		Method[] methods = obj.getClass().getDeclaredMethods();
		System.out.println("<" + obj.getClass().getSimpleName() + ">");
		for (Method m : methods) {
			if(m.getName().startsWith("get")) {
				try {
					System.out.println("<" + m.getName().substring(3) + ">" + m.invoke(obj) + "</" + m.getName().substring(3) + ">");
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("</" + obj.getClass().getSimpleName() + ">");
		System.out.println("----------");
	}

}
