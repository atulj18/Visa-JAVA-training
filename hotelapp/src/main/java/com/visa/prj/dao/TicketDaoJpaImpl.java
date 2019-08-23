package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.client.TicketReport;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Repository
public class TicketDaoJpaImpl implements TicketDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addTicket(Ticket t) {
		em.persist(t);
	}

	@Override
	public Ticket updateTicket(Ticket t) {
		em.merge(t);
		return t;
	}

	@Override
	public List<Ticket> findOpen() {
		String jpql = "select t from Ticket t where t.resolved_by is null";
		TypedQuery<Ticket> query = em.createQuery(jpql, Ticket.class);
		return query.getResultList();
	}

	@Override
	public Employee getbyId(String user) {
		return em.find(Employee.class, user);
	}

	@Override
	public List<TicketReport> getReports() {
		String jpql = "select new com.visa.prj.client.TicketReport(t.id, t.resolved_desc, t.resolved_by.username, t.raised_date, t.resolved_date) from Ticket t";
		TypedQuery<TicketReport> query = em.createQuery(jpql, TicketReport.class);
		return query.getResultList();
	}

}
