package com.shoppingcart.form;

import java.util.List;

public class CartListForm {

	private Integer productId;
	private String productName;
	private String productDetails;
	private Integer productTotalCost;
	private String quantity;
	private Integer grandTotal;
	
	
	public Integer getGrandTotal() {
		return grandTotal;
	}
	
	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	private List<String> selectedProduct;
	
	
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
	public Integer getProductTotalCost() {
		return productTotalCost;
	}
	public void setProductTotalCost(Integer productTotalCost) {
		this.productTotalCost = productTotalCost;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public List<String> getSelectedProduct() {
		return selectedProduct;
	}
	public void setSelectedProduct(List<String> selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	
	
	
	
}
