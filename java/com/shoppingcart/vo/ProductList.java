package com.shoppingcart.vo;

import java.util.List;

public class ProductList {

	private Integer productId;
	private String productName;
	private String productDetails;
	private String productQuantity;
	private String productCost;
	private List<String> selectedProduct;
	
	
	
	public List<String> getSelectedProduct() {
		return selectedProduct;
	}
	public void setSelectedProduct(List<String> selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductCost() {
		return productCost;
	}
	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}
	
	
}
