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
import com.anshu.basic.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;

	@DeleteMapping("deleteProduct/{productid}")
	public String updateSeller(@PathVariable Integer productid) {
		productService.deleteProduct(productid);
		return "Product Deleted...";
	}
	
	@PostMapping("addProduct/{sellerId}")
	public String addProduct( @RequestBody Product product, @PathVariable Integer sellerId){
		productService.addProduct( sellerId, product);
		return "Product Added Successfully..";
	}
	@PutMapping("updateProduct/sellerId/{sellerId}/productId/{productId}")
	public String updateProduct(@PathVariable Integer sellerId, @PathVariable Integer productId, @RequestBody Product product)
	{
		productService.updateProduct(sellerId, productId, product);
		return "Product Details Updated Successfully";
	}
	
	@GetMapping("ByProductId/{productId}")
	public ResponseEntity<Product> findByProductId(@PathVariable Integer productId){
		return ResponseEntity.ok(productService.findProductById(productId));
	}
	
	@GetMapping("ByProductName/{productName}")
	public List<Product> findByProductName(@PathVariable String productName){
		return productService.findProductByName(productName);
	}
	
	@GetMapping("ByProductType/{productType}")
	public List<Product> findByProductType(@PathVariable String productType){
		return productService.findProductByType(productType);
	}
}
