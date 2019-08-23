package com.visa.fundraising.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "campaigns")
public class Campaign {
	@Id
	private String name;
	private double target;
	private double collected;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date deadline;
	private String status;
	private String description;
	
	public Campaign() {
		this.collected = 0.0;
	}

	public Campaign(String name, double target, Date deadline, String status, String description) {
		this.name = name;
		this.target = target;
		this.deadline = deadline;
		this.status = status;
		this.description = description;
		this.collected = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTarget() {
		return target;
	}

	public void setTarget(double target) {
		this.target = target;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCollected() {
		return collected;
	}

	public void setCollected(double collected) {
		this.collected = collected;
	}
}
