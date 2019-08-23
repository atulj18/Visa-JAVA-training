package com.visa.prj.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greet")
public class GreetingController {
	
	@GetMapping()
	public String helloGreet() {
		return "Hello from Spring Boot!!!";
	}
}
