package com.visa.prj.client;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TicketReport {
	private long id;
	private String desc;
	private String resolvedby;
	private long hourstaken;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getResolvedby() {
		return resolvedby;
	}
	public void setResolvedby(String resolvedby) {
		this.resolvedby = resolvedby;
	}
	public long getHourstaken() {
		return hourstaken;
	}
	public void setHourstaken(long hourstaken) {
		this.hourstaken = hourstaken;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	private Date start;
	private Date end;
	public TicketReport(long id, String desc, String resolvedby, Date start, Date end) {
		this.id = id;
		this.desc = desc;
		this.resolvedby = resolvedby;
		this.start = start;
		this.end = end;
		this.hourstaken = TimeUnit.HOURS.convert((end.getTime() - start.getTime()), TimeUnit.MILLISECONDS);
	}
	
}
