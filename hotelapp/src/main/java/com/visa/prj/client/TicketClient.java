package com.visa.prj.client;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;

public class TicketClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		TicketService os = ctx.getBean("ticketService", TicketService.class);
		
		Employee e1 = os.getEmployee("a@visa.com");
		Employee e2 = os.getEmployee("b@visa.com");
		
		os.raiseTicket(e2, "Laptop issue");
		List<Ticket> list = os.listAllOpenTkts();
		for (Ticket t : list) {
			System.out.println(t.getId() + "," + t.getTicket_desc());
			os.resolveTicket(t, e1, "Booted Ram");
		}
		List<TicketReport> reports = os.getReports();
		for (TicketReport r : reports) {
			System.out.println(r.getId() + "," + r.getDesc() + "," + r.getHourstaken());
		};
	}

}
