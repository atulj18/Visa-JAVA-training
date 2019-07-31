package com.visa.prj.entity;

public class Time {
	private int hours;
	private int min;
	public Time() {
	}
	public Time(int hours, int min) {
		this.hours = hours;
		this.min = min;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public static Time addTime(Time t1, Time t2) {
		Time t = new Time();
		if(t1.getMin() + t2.getMin() > 60) {
			t.setMin(t1.getMin() + t2.getMin() - 60);
			t.setHours(t1.getHours() + t2.getHours() + 1);
		}else {
			t.setMin(t1.getMin() + t2.getMin());
			t.setHours(t1.getHours() + t2.getHours());
		}
		return t;
	}
	public Time addTime(Time t2) {
		return Time.addTime(this, t2);
	}
	
}
