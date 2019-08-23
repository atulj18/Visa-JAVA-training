package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.client.TicketReport;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

public interface TicketDao {
	public void addTicket(Ticket t);
	public Ticket updateTicket(Ticket t);
	public List<Ticket> findOpen();
	public Employee getbyId(String user);
	public List<TicketReport> getReports();
}
