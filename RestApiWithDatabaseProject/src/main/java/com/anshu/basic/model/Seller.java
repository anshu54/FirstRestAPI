package com.anshu.basic.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sellerId;
	private String sellerName;
	private String sellerType;
	private String sellerDomain;
	private String sellerMobNo;
	private String sellerEmail;
	
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> product;
	
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerType() {
		return sellerType;
	}
	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}
	public String getSellerDomain() {
		return sellerDomain;
	}
	public void setSellerDomain(String sellerDomain) {
		this.sellerDomain = sellerDomain;
	}
	public String getSellerMobNo() {
		return sellerMobNo;
	}
	public void setSellerMobNo(String sellerMobNo) {
		this.sellerMobNo = sellerMobNo;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	

}
