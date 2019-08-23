package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	
	private String ticket_desc;
	
	private Date raised_date;
	
	@ManyToOne
	@JoinColumn(name="raised_by")
	private Employee raised_by;
	
	@ManyToOne
	@JoinColumn(name="resolved_by")
	private Employee resolved_by;
	
	private Date resolved_date;
	
	private String resolved_desc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicket_desc() {
		return ticket_desc;
	}

	public void setTicket_desc(String ticket_desc) {
		this.ticket_desc = ticket_desc;
	}

	public Date getRaised_date() {
		return raised_date;
	}

	public void setRaised_date(Date start_date) {
		this.raised_date = start_date;
	}

	public Employee getRaised_by() {
		return raised_by;
	}

	public void setRaised_by(Employee raised_by) {
		this.raised_by = raised_by;
	}

	public Employee getResolved_by() {
		return resolved_by;
	}

	public void setResolved_by(Employee resolved_by) {
		this.resolved_by = resolved_by;
	}

	public Date getResolved_date() {
		return resolved_date;
	}

	public void setResolved_date(Date end_date) {
		this.resolved_date = end_date;
	}

	public String getResolved_desc() {
		return resolved_desc;
	}

	public void setResolved_desc(String resolved_desc) {
		this.resolved_desc = resolved_desc;
	}
	
}
