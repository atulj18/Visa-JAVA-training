package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		String jpql = "select h from Hotel h where h.name like :na or h.city like :ci or h.state like :st";
		TypedQuery<Hotel> query = em.createQuery(jpql,Hotel.class);
		query.setParameter("na", "%" + criteria + "%");
		query.setParameter("ci", "%" + criteria + "%");
		query.setParameter("st", "%" + criteria + "%");
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		String jpql = "select u from User u where u.email = :em and u.password = :pa";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("em", email);
		query.setParameter("pa", password);
		return query.getResultList().get(0);
	}
	
	@Override
	public User getUser(String email) {
		String jpql = "select u from User u where u.email = :em";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("em", email);
		return query.getResultList().get(0);
	}

	@Override
	public void createBooking(Booking booking) {
		em.persist(booking);
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String jpql = "select b from Booking b where b.user = :us";
		TypedQuery<Booking> query = em.createQuery(jpql,Booking.class);
		query.setParameter("us", user);
		return query.getResultList();
	}

}
