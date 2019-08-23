package com.visa.prj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

public class SQLUtil {
	
	public static String generateCreateSQL(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		Table t = clazz.getAnnotation(Table.class);
		if(t != null) {
			builder.append("create table");
			builder.append(" ");
			builder.append(t.name());
			builder.append("(");
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			if(m.getName().startsWith("get")) {
				Column c = m.getAnnotation(Column.class);
				if(c != null) {
					builder.append(c.name());
					builder.append(" ");
					builder.append(c.type());
					builder.append(", ");
				}
			}
		}
		builder.setCharAt(builder.lastIndexOf(","), ')');
		return builder.toString();
	}
	
	public static String generateInsertSQL(Object obj) {
		StringBuilder builder = new StringBuilder();
		Table t = obj.getClass().getAnnotation(Table.class);
		builder.append("insert into ");
		builder.append(t.name());
		builder.append(" values(");
		Method[] methods = obj.getClass().getDeclaredMethods();
		for (Method m : methods) {
			if(m.getName().startsWith("get")) {
				Column c = m.getAnnotation(Column.class);
				if(c != null) {
					try {
						builder.append(m.invoke(obj));
						builder.append(", ");
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		builder.setCharAt(builder.lastIndexOf(","), ')');
		return builder.toString();
	}
}
