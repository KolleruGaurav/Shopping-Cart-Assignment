package com.shoppingcart.form;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class FormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return LoginForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "userId","arg1.userId", "UserId should not be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password","arg1.password", "Password should not be Empty");
	}

	
}
