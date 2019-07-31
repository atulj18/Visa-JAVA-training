package com.visa.prj.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void testAddTimeTimeTime() {
		Time t1 = new Time(3, 30);
		Time t2 = new Time(6, 15);
		Time t3 = new Time(2, 50);
		Time ex1 = new Time(9, 45);
		Time ex2 = new Time(9, 5);
		assertEquals(ex1.getHours(), Time.addTime(t1, t2).getHours());
		assertEquals(ex1.getMin(), Time.addTime(t1, t2).getMin());
		assertEquals(ex2.getHours(), Time.addTime(t2, t3).getHours());
		assertEquals(ex2.getMin(), Time.addTime(t2, t3).getMin());
	}

	@Test
	public void testAddTimeTime() {
		Time t1 = new Time(3, 30);
		Time t2 = new Time(6, 15);
		Time t3 = new Time(2, 50);
		Time ex1 = new Time(9, 45);
		Time ex2 = new Time(9, 5);
		assertEquals(ex1.getHours(), t1.addTime(t2).getHours());
		assertEquals(ex1.getMin(), t1.addTime(t2).getMin());
		assertEquals(ex2.getHours(), t2.addTime(t3).getHours());
		assertEquals(ex2.getMin(), t2.addTime(t3).getMin());
	}

}
