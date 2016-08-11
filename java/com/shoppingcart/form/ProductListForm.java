package com.shoppingcart.form;

import java.util.List;

public class ProductListForm {

	private Integer productId;
	private String productName;
	private String productDetails;
	private String productQuantity;
	private String productCost;
	private List<String>  selectedProduct;
	private List<String> selectedQuantity;
	
	
	public List<String> getSelectedQuantity() {
		return selectedQuantity;
	}
	public void setSelectedQuantity(List<String> selectedQuantity) {
		this.selectedQuantity = selectedQuantity;
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
	public List<String>  getSelectedProduct() {
		return selectedProduct;
	}
	public void setSelectedProduct(List<String>  selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	
}
