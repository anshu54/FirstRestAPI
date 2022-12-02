package com.anshu.basic.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anshu.basic.dao.ProductRepository;
import com.anshu.basic.dao.SellerRepository;
import com.anshu.basic.exception.ResourceNotFoundException;
import com.anshu.basic.model.Product;
import com.anshu.basic.model.Seller;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Seller addSeller(Seller seller) {
		return sellerRepository.save(seller);
	}

	@Override
	public Seller getSeller(Integer sellerId) {
		
		Seller seller=sellerRepository.findById(sellerId).orElseThrow(()-> new ResourceNotFoundException());
		return seller;	
	}

	@Override
	public Seller updateSeller(Seller seller, Integer sellerId) {
		Seller sellerold=sellerRepository.findById(sellerId).orElseThrow(()-> new ResourceNotFoundException());
		sellerold=modelMapper.map(seller, Seller.class);
		  sellerold.setSellerId(sellerId);
		return sellerRepository.save(sellerold);
	}

	@Override
	public void deleteSeller(Integer sellerId) {
		Seller seller=sellerRepository.findById(sellerId).orElseThrow((()->new ResourceNotFoundException()));
		sellerRepository.delete(seller);
		
	}

	@Override
	public List<Seller> findBySellerName(String sellerName) {
		List<Seller> sellerList=sellerRepository.findBySellerNameLike("%"+sellerName+"%");
		if(sellerList.isEmpty())
			throw new ResourceNotFoundException(); 
		else
			return sellerList;			
	}

	

	
	

	
	

}
