package com.shoppingcart.service;

import java.util.List;
import java.util.Map;

import com.shoppingcart.vo.ProductList;
import com.shoppingcart.vo.User;

public interface IAuthService {

	public User login(String strUserLoginID, String encryptedPwd) throws Exception;

	public List<ProductList> getProductList();

	public List<ProductList> getCartList(Map<String, String> cartlist);

	public void getCheckouttList(Integer remaningQuantity, Integer id);	
	
}
