package com.anshu.basic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anshu.basic.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>  {
	
	public List<Product> findByProductNameContains(String Name);
	public List<Product> findByProductTypeContains(String productType);
	
	
	

}
