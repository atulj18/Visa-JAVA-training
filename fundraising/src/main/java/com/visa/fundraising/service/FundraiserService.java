package com.visa.fundraising.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.fundraising.dao.CampaignDao;
import com.visa.fundraising.dao.DonationDao;
import com.visa.fundraising.entity.Campaign;
import com.visa.fundraising.entity.Donation;

@Service
public class FundraiserService {
	@Autowired
	private CampaignDao cd;
	
	@Autowired
	private DonationDao dd;
	
	public List<Campaign> listCampaigns(){
		return cd.findAll();
	}
	
	public Campaign findCampaign(String name) {
		return cd.findById(name).get();
	}
	
	@Transactional
	public void addCampaign(Campaign c) {
		cd.save(c);
	}
	
	public List<Donation> listDonations(){
		return dd.findAll();
	}
	
	@Transactional
	public void addDonation(Donation d) {
		dd.save(d);
		Campaign c = findCampaign(d.getCampaign().getName());
		c.setCollected(c.getCollected() + d.getAmount());
	}
}
