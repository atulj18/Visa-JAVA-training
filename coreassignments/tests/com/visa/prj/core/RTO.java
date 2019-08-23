package com.visa.prj.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RTO {
	
	private static Map<String, String> Area;
	
	public static void main(String[] args) {
		Map<String, String> codes = new HashMap<String, String>();
		codes.put("KA-01", "Koramangala");
		codes.put("KA-02", "Rajajinagar");
		codes.put("KA-03", "Indiranagar");
		codes.put("KA-04", "Yeshwanthpur");
		codes.put("KA-05", "Jayanagar");
		codes.put("KA-50", "Yelahanka");
		codes.put("KA-51", "Electronics City");
		codes.put("KA-52", "Nelamangala");
		codes.put("KA-53", "K.R.Puram");
		codes.put("KA-54", "Nagamangala");
		codes.put("KA-55", "Mysore East");
		codes.put("KA-56", "Basavakalyan");
		codes.put("KA-57", "Shantinagar");
		Area = codes;
		List<String> regNo = getInput();
		sortreg(regNo);
		System.out.println(regNo);
	}
	private static void sortreg(List<String> regNo) {
		regNo.sort((a, b) -> (Area.get(a.substring(0, 5)) + a.substring(6)).compareTo(Area.get(b.substring(0, 5)) + b.substring(6)));
	}
	private static List<String> getInput() {
		List<String> in = new ArrayList<String>();
		in.add("KA-01-98302");
		in.add("KA-01-76540");
		in.add("KA-56-98302");
		in.add("KA-03-76543");
		in.add("KA-54-swdxgwy");
		return in;
	}
	
	
	
}
