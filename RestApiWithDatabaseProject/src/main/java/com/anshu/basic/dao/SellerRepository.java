package com.anshu.basic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anshu.basic.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
	public List<Seller> findBySellerNameLike(String sellerName);
	

}
