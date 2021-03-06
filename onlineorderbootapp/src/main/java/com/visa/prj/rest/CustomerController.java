package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Customer;
import com.visa.prj.service.OrderService;

@RestController
public class CustomerController {
	@Autowired
	private OrderService os;
	
	@GetMapping("customers")
	public @ResponseBody List<Customer> getCustomers() {
		return os.getCustomers();
		
	}
	
	@GetMapping("customers/{email}")
	public @ResponseBody Customer getProductById(@PathVariable("email") String email) {
		return os.getCustomerByEmail(email);
	}
	
	@PostMapping("customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
		os.saveCustomer(c);
		return new ResponseEntity<>(c, HttpStatus.CREATED); //201
	}
}
