package com.visa.fundraising.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.fundraising.entity.Donation;

public interface DonationDao extends JpaRepository<Donation, Integer> {

}
