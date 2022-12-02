package com.anshu.basic.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anshu.basic.dao.ProductRepository;
import com.anshu.basic.dao.SellerRepository;
import com.anshu.basic.exception.ResourceNotFoundException;
import com.anshu.basic.model.Product;
import com.anshu.basic.model.Seller;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public void deleteProduct(Integer productId) {
		Product product=productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException());
		productRepository.deleteById(productId);
				
	}

	@Override
	public Product findProductById(Integer productId) {
		Product product=productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException());
		return product;
	}

	@Override
	public List<Product> findProductByName(String productName) {
		List<Product> productList=productRepository.findByProductNameContains(productName);
		if(productList.isEmpty())
			throw new ResourceNotFoundException(); 
		else
			return productList;
	}


	@Override
	public List<Product> findProductByType(String productType) {
		List<Product> productList=productRepository.findByProductTypeContains(productType);
		if(productList.isEmpty())
			throw new ResourceNotFoundException(); 
		else
			return productList;
	}

	@Override
	public Product addProduct(Integer sellerId, Product productnew) {
		Seller seller=sellerRepository.findById(sellerId).orElseThrow(()-> new ResourceNotFoundException());
		Product product=modelMapper.map(productnew, Product.class);
		product.setSeller(seller);
		return productRepository.save(product);
		
	}

	@Override
	public Product updateProduct(Integer sellerId, Integer productId, Product productNew) {
		Seller seller=sellerRepository.findById(sellerId).orElseThrow(()-> new ResourceNotFoundException());
		Product productOld=productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException());
		productOld=modelMapper.map(productNew, Product.class);
		productOld.setSeller(seller);
		productOld.setProductId(productId);
		return productRepository.save(productOld);
	}

}
