package com.visa.fundraising.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.fundraising.entity.Campaign;

public interface CampaignDao extends JpaRepository<Campaign, String> {

}
