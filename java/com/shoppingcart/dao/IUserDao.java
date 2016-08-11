package com.shoppingcart.dao;
import java.util.List;
import java.util.Map;

import com.shoppingcart.vo.ProductList;
import com.shoppingcart.vo.User;

public interface IUserDao {
  public User checkUser(String userid, String password);

public List<ProductList> getAllProduct();

public List<ProductList> getCartProduct(Map<String, String> cartlist);

public void updateCartProduct(Integer remaningQuantity, Integer id);
}
