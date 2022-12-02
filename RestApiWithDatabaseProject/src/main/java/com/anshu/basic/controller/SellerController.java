package com.anshu.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anshu.basic.model.Product;
import com.anshu.basic.model.Seller;
import com.anshu.basic.service.SellerServiceImpl;

@RestController
public class SellerController {
	@Autowired
	private SellerServiceImpl sellerService;
	
	@PostMapping("addSeller")
	public String addSeller(@RequestBody Seller seller){
		sellerService.addSeller(seller);
		return "Seller Record added Successfully...";
	}
	
	@GetMapping("getSeller/{sellerId}")
	public ResponseEntity<Seller> getSeller(@PathVariable Integer sellerId){
		return ResponseEntity.ok(sellerService.getSeller(sellerId));	
	}
	@PutMapping("updateSeller/{sellerId}")
	public String updateSeller(@PathVariable Integer sellerId, @RequestBody Seller seller)
	{
		sellerService.updateSeller(seller, sellerId);
		return "Record Updated Successfully..";
	}
	
	@DeleteMapping("deleteSeller/{sellerId}")
	public String deleteSeller(@PathVariable Integer sellerId){
		sellerService.deleteSeller(sellerId);
		return "Seller Record deleted..";
	}
	
	@GetMapping("getSellerByName/{sellerName}")
	public List<Seller> findBySellerName(@PathVariable String sellerName){
		return sellerService.findBySellerName(sellerName);
	}
	
	

}
