package com.visa.prj.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.client.TicketReport;
import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {
	
	@Autowired
	private TicketDao ticketDao;
	
	@Transactional
	public void raiseTicket(Employee e, String desc) {
		Ticket t = new Ticket();
		t.setRaised_by(e);
		t.setTicket_desc(desc);
		t.setRaised_date(new Date());
		ticketDao.addTicket(t);
	}
	
	public List<Ticket> listAllOpenTkts(){
		return ticketDao.findOpen();
	}
	
	@Transactional
	public Ticket resolveTicket(Ticket t, Employee e, String desc) {
		t.setResolved_by(e);
		t.setResolved_desc(desc);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 6);
		t.setResolved_date(calendar.getTime());
		return ticketDao.updateTicket(t);
	}

	public Employee getEmployee(String user) {
		return ticketDao.getbyId(user);
	}

	public List<TicketReport> getReports() {
		return ticketDao.getReports();
	}
}
