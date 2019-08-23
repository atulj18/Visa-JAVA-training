package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.dao.BookingDao;

@Controller
public class SearchController {
	
	@Autowired
	private BookingDao dao;

	@RequestMapping("search.do")
	public ModelAndView startSearching(@RequestParam("criteria") String criteria) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchResults.jsp");
		mav.addObject("hotelList", dao.findHotels(criteria));
		return mav;
	}
	
	@RequestMapping("viewHotel.do")
	public ModelAndView viewhotel(@RequestParam("id") long id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showHotel.jsp");
		mav.addObject("hotel", dao.findHotelById(id));
		return mav;
	}
		 
}
