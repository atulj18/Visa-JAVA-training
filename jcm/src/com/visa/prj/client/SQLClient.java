package com.visa.prj.client;

import com.visa.prj.entity.Product;
import com.visa.prj.util.SQLUtil;

public class SQLClient {

	public static void main(String[] args) {
		String CREATE_SQL = SQLUtil.generateCreateSQL(Product.class);
		System.out.println(CREATE_SQL);
		
		Product p = new Product(120, "iPhoneXR", 100000, "mobile", 2);
		String insert = SQLUtil.generateInsertSQL(p);
		System.out.println(insert);
	}

}
