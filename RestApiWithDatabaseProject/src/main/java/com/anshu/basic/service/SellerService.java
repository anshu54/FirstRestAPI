package com.anshu.basic.service;

import java.util.List;
import com.anshu.basic.model.Seller;

public interface SellerService {
	public Seller addSeller(Seller seller);
	public Seller updateSeller(Seller Seller, Integer sellerId);
	public void deleteSeller(Integer sellerId);
	
	public Seller getSeller(Integer sellerId);
	public List<Seller> findBySellerName(String sellerName);
	
	
	
	

}
