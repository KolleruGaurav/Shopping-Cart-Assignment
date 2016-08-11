package com.shoppingcart;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.shoppingcart.service.IAuthService;

@Component
public class BusinessDeligate implements ApplicationListener<ContextRefreshedEvent> {
	private static IAuthService authService;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent obj) {
		authService=(IAuthService) obj.getApplicationContext().getBean("authService");
	}
	
	public static IAuthService getAuthService() {
		return authService;
	}
}
