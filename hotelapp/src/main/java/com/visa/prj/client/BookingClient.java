package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Hotel;
import com.visa.prj.service.BookingService;

public class BookingClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		BookingService bs = ctx.getBean("bookingService", BookingService.class);
		List<Hotel> list = bs.findHotels("NY");
		for(Hotel h : list)
			System.out.println(h.getId() + "," + h.getName());
		System.out.println(bs.getUser("b@visa.com", "xyz"));
		System.out.println(bs.getHotelById(12));
	}

}
