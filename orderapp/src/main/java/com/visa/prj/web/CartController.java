package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.service.OrderService;

@Controller
public class CartController {
	
	@Autowired
	private OrderService os;
	
	@RequestMapping("cart.do")
	public String addToCart(HttpServletRequest req) {
		String[] prds = req.getParameterValues("prds");
		HttpSession ses = req.getSession();
		os.orderByProductIds(prds, (String)ses.getAttribute("user"));
		return "index.jsp";
	}
}
