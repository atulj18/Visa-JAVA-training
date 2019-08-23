package com.visa.fundraising.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.fundraising.entity.Campaign;
import com.visa.fundraising.entity.Donation;
import com.visa.fundraising.service.FundraiserService;

@RestController
public class FundraiserController {
	@Autowired
	private FundraiserService fs;
	
	@GetMapping("campaigns")
	public @ResponseBody List<Campaign> getCampaigns(){
		return fs.listCampaigns();
	}
	
	@PostMapping("campaigns")
	public ResponseEntity<Campaign> placeOrder(@RequestBody Campaign c){
		fs.addCampaign(c);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	
	@GetMapping("donations")
	public @ResponseBody List<Donation> getDonations(){
		return fs.listDonations();
	}
	
	@PostMapping("donations")
	public ResponseEntity<Donation> placeOrder(@RequestBody Donation d){
		fs.addDonation(d);
		return new ResponseEntity<>(d, HttpStatus.CREATED);
	}
}

