package com.shoppingcart;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
		
	@ExceptionHandler(Throwable.class)
	
	public ModelAndView handleException(Throwable t){
	
		ModelAndView mav=new ModelAndView("techDiff");
		mav.addObject("msg","There is some technical difficulty");
		return mav;
		
	}
}
