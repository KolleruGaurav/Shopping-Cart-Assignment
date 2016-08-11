package com.shoppingcart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingcart.BusinessDeligate;
import com.shoppingcart.form.CartListForm;
import com.shoppingcart.form.FormValidator;
import com.shoppingcart.form.LoginForm;
import com.shoppingcart.form.ProductListForm;
import com.shoppingcart.vo.ProductList;
import com.shoppingcart.vo.User;

@Controller
public class LoginController {

	@RequestMapping(value = "/showLogin.action")
	public ModelAndView getLoginPage(ModelAndView mav, HttpSession session) {
			 
			LoginForm loginForm = new LoginForm();
			mav.addObject("loginForm", loginForm);
			mav.setViewName("login");
		
		return mav;
	}
	
	@Autowired
	FormValidator validator;
	@InitBinder("loginForm")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/login.action")
	public ModelAndView showHome(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session,BindingResult result) throws Exception {
		validator.validate(loginForm, result);
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()){
			 mav.setViewName("login");
			 return mav;
		}
		
		String inputUsername = loginForm.getUserId().trim();
		String inputPassword = loginForm.getPassword();
			
		User userInfo = BusinessDeligate.getAuthService().login(
				inputUsername, inputPassword);
		
		if(userInfo != null){	
			session.setAttribute("userInfo", userInfo);
			return new ModelAndView("redirect:/productlist.action");
			//mav.setViewName("welcome");
			
		}else{
			mav.addObject("errorMessage",
					"Invalid credentials. Please try again.");
			mav.setViewName("login");
		}
		
		//System.out.println(userInfo);
		
		return mav;
		
}
	@RequestMapping(value = "/productlist.action")
	public ModelAndView getProductList(ModelAndView mav, HttpSession session) {
		
		ProductListForm product = new ProductListForm();	
		
		List<ProductList> productlist = BusinessDeligate.getAuthService().getProductList();
		session.setAttribute("productlist", productlist);
		mav.addObject("product", product);
		mav.addObject("productList", productlist);
		mav.setViewName("productlist");
		return mav;
	}
	
	@RequestMapping(value = "/cartlist.action")
	public ModelAndView getcartList(@ModelAttribute("product") ProductListForm productListForm, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		CartListForm cartProduct = new CartListForm();
		
		Map<String, String> cartlist = new HashMap<String, String>();
		
		
			
		  for(int i =0, j=0; i < productListForm.getSelectedQuantity().size(); i++){
			
			if(!productListForm.getSelectedQuantity().get(i).contains("-1")){
	 
		          	 cartlist.put(productListForm.getSelectedProduct().get(j), productListForm.getSelectedQuantity().get(i));
		          	 
		          	 j++;
		          	 
			}
			
		}
		
        if(!cartlist.isEmpty()){
		session.setAttribute("cartlist", cartlist);
		
		List<ProductList> productlist = BusinessDeligate.getAuthService().getCartList(cartlist);
		
		List<CartListForm> cartList = new ArrayList<CartListForm>();
		
	    Iterator itr = productlist.iterator();
		while(itr.hasNext()){
			CartListForm cart = new CartListForm();
		
			
			ProductList product = (ProductList) itr.next();
			String id= product.getProductId().toString();
			cart.setProductId(product.getProductId());
			cart.setProductName(product.getProductName());
			cart.setProductDetails(product.getProductDetails());
			String strQuantity = cartlist.get(id);
			int cost =    Integer.parseInt(product.getProductCost());
			
			int quantity = Integer.parseInt(strQuantity);
				
			int totalcost = cost * quantity;
			cart.setProductTotalCost(totalcost);
			
			cart.setQuantity(strQuantity);
			
			cartList.add(cart);
			
			
		}
		mav.addObject("cartProduct", cartProduct);
		
		
		//mav.addObject("productList", productlist);
		mav.addObject("cartList", cartList);
		mav.setViewName("cartlist");
		return mav;
		}else{
			mav.addObject("errorMessage",
					"Please Specify Qunatity of selected Product");
		   mav.setViewName("cartlist");
			return mav;
		}
	}
	
	@RequestMapping(value = "/checkout.action")
public ModelAndView getCheckoutListt(@ModelAttribute("cartProduct") CartListForm cartListForm, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		CartListForm cartProduct = new CartListForm();
		int grandtotal = 0;
		Map<String, String> cartlist = new HashMap<String, String>();
		
		cartlist = (Map<String, String>) session.getAttribute("cartlist");
		
		System.out.println("size"+cartlist.size());
		
		if(cartListForm.getSelectedProduct() != null){
		for(int i =0; i < cartListForm.getSelectedProduct().size(); i++){
			 
              cartlist.remove(cartListForm.getSelectedProduct().get(i));	             
		}
		}
		
		//session.setAttribute("cartlist", cartlist);
		if(!cartlist.isEmpty()){
		
	    
		List<ProductList> productlist = BusinessDeligate.getAuthService().getCartList(cartlist);
		
	    
	
		List<CartListForm> cartList = new ArrayList<CartListForm>();
		
	    Iterator itr = productlist.iterator();
	    
		while(itr.hasNext()){
			CartListForm cart = new CartListForm();		
			ProductList product = (ProductList) itr.next();
			
			String id= product.getProductId().toString();
			cart.setProductId(product.getProductId());
			cart.setProductName(product.getProductName());
			cart.setProductDetails(product.getProductDetails());
			String strQuantity = cartlist.get(id);
			
			int cost =    Integer.parseInt(product.getProductCost());
			
		    int actualQuantity = Integer.parseInt(product.getProductQuantity());
			
			int quantity = Integer.parseInt(strQuantity);
			
			int remaningQuantity = actualQuantity - quantity;
			
			int totalcost = cost * quantity;
			grandtotal += totalcost; 
			
			cart.setProductTotalCost(totalcost);
			
			cart.setQuantity(strQuantity);
			
			cartList.add(cart);
			
			BusinessDeligate.getAuthService().getCheckouttList(remaningQuantity,product.getProductId());
		}
		
		
		
		mav.addObject("cartProduct", cartProduct);
		
		User userInfo = (User) session.getAttribute("userInfo");
		
		//mav.addObject("productList", productlist);
		String name = userInfo.getFname() +" "+userInfo.getLname();
		
		mav.addObject("userName",name );
		mav.addObject("cartList", cartList);
		mav.addObject("grandtotal", grandtotal);
		mav.setViewName("checkout");
		return mav;
	   }else{
		   mav.addObject("errorMessage",
					"Please select any product for checkout.");
		   mav.setViewName("checkout");
			return mav;
	   }
	}
	
	@RequestMapping(value = "/logout.action")
	public ModelAndView logout(ModelAndView mav, HttpSession session) {
		
	   session.invalidate();

		mav.addObject("loginForm", new LoginForm());
		mav.addObject("successMessage", "You are logged out successfully!");
		mav.setViewName("login");

		return mav;
	}
}	
