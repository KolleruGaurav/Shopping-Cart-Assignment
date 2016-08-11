package com.shoppingcart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingcart.vo.ProductList;
import com.shoppingcart.vo.User;
import com.shoppingcart.dao.IUserDao;

public class AuthService implements IAuthService{
	
	@Autowired
	private IUserDao userDao;
	
	public User login(String strUserLoginID, String password)
			throws Exception {
		
		User user = userDao.checkUser(strUserLoginID, password);
		
		return user;
	}
	
	public List<ProductList> getProductList(){
		
		return userDao.getAllProduct();
	}
	
      public List<ProductList> getCartList(Map<String, String> cartlist){
		
		return userDao.getCartProduct(cartlist);
	}
      
      public void getCheckouttList(Integer remaningQuantity, Integer id){
  		
  		 userDao.updateCartProduct(remaningQuantity,id);
  	}
}
