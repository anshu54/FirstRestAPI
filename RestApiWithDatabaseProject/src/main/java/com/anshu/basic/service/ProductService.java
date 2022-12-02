package com.anshu.basic.service;

import java.util.List;

import com.anshu.basic.model.Product;
import com.anshu.basic.model.Seller;

public interface ProductService {
	public Product addProduct(Integer sellerId, Product product);
	public Product updateProduct( Integer sellerId, Integer productId, Product product);
	public void deleteProduct(Integer productId);
	public Product findProductById(Integer productId);
	public List<Product> findProductByName(String productName);
	public List<Product> findProductByType(String productType);

}
