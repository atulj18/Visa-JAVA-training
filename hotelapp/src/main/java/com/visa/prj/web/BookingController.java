package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.service.BookingService;

@Controller
public class BookingController {
	@Autowired
	private BookingService bs;

	@RequestMapping("booking.do")
	public ModelAndView startSearching(@RequestParam("id") long id, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		Object email = req.getSession(false).getAttribute("user");
		if(email==null) {
			mav.setViewName("login.html");
		}
		else{
			mav.setViewName("bookingForm.jsp");
			mav.addObject("booking", new Booking(bs.getHotelById(id), bs.getUser((String)email)));
		}
		return mav;
	}
	
	@RequestMapping("placeReservation.do")
	public ModelAndView makeReservation(@ModelAttribute("booking") Booking b, HttpServletRequest req) {
		b.setUser(bs.getUser(b.getUser().getEmail()));
		b.setHotel(bs.getHotelById(b.getHotel().getId()));
		bs.makeBooking(b);
		Object email = req.getSession(false).getAttribute("user");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showBookings.jsp");
		mav.addObject("bookingList", bs.getAllBookingsByUser(bs.getUser((String)email)));
		return mav;
	}
	
//	@RequestMapping("showbks.do")
//	public ModelAndView showbookings(HttpServletRequest req) {
//		Object email = req.getSession(false).getAttribute("user");
//		ModelAndView mav = new ModelAndView();
//		if(email==null)
//			mav.setViewName("login.html");
//		else {
//			mav.setViewName("showBookings.jsp");
//			mav.addObject("bookingList", bs.getAllBookingsByUser(bs.getUser((String)email)));
//		}
//		return mav;
//	}
}
