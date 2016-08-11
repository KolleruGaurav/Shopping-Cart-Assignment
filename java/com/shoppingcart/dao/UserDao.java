package com.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shoppingcart.vo.ProductList;
import com.shoppingcart.vo.User;

public class UserDao extends HibernateDaoSupport implements IUserDao{
 
	public User checkUser(String userid, String password){
		
		String hqlQuery = "from User u where u.userID =:userId and u.password = :password";
		Query query = getSession().createQuery(hqlQuery)
				.setParameter("userId", userid)
				.setParameter("password",password );
	
		return (User) query.uniqueResult();
	}
	
	public List<ProductList> getAllProduct(){
		return getHibernateTemplate().loadAll(ProductList.class);
		
	}
	
	public List<ProductList> getCartProduct(Map<String, String> cartlist){
		//return getHibernateTemplate().loadAll(ProductList.class);
		List<Integer> productId = new ArrayList<Integer>();
		for (Map.Entry<String, String> entry : cartlist.entrySet())
		{
		    System.out.println(entry.getKey());
		    productId.add(Integer.parseInt(entry.getKey()));
		   
		}
		
		String hqlQuery = "from  ProductList p where p.productId IN (:productId) ";
		Query query = getSession().createQuery(hqlQuery)
				.setParameterList("productId",productId );
					
		return (List<ProductList>) query.list();
	
	}
	@Override
	public void updateCartProduct(Integer remaningQuantity, Integer id){

		String hqlQuery = "update  ProductList p set p.productQuantity =:quantity where p.productId =:productId";
		Query query = getSession().createQuery(hqlQuery)
				.setParameter("quantity",remaningQuantity.toString())
				.setParameter("productId",id);
				
			   query.executeUpdate();	
		       
	}


}
