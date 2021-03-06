package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RestController
public class ProductController {
	@Autowired
	private OrderService os;
	
//	@GetMapping("products")
//	public @ResponseBody List<Product> getProducts() {
//		return os.getProducts();
//	}
	
	@GetMapping("products")
	public @ResponseBody List<Product> getProductsPrice(@RequestParam(name="price", defaultValue="0") double price) {
		if(price > 0)
			return os.getProductsByPrice(price);
		return os.getProducts();
		
	}
	
	@GetMapping("products/{id}")
	public @ResponseBody Product getProductById(@PathVariable("id") int id) {
		return os.getById(id);
	}
	
	@PostMapping("products")
	public ResponseEntity<Product> addProduct(@RequestBody Product p){
		os.saveProduct(p);
		return new ResponseEntity<>(p, HttpStatus.CREATED); //201
	}
}
