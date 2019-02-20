package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user=(User) target;
	
		if(StringUtils.isEmpty(user.getUserName())) {
			errors.rejectValue("userName",null,"Please Enter Username...");
		}
		
		if(StringUtils.isEmpty(user.getMail())) {
			errors.rejectValue("mail",null,"Please Enter mail...");
		}
		
		if(StringUtils.isEmpty(user.getMobile())) {
			errors.rejectValue("mobile",null,"Please Enter mobile...");
		}
		
		if(StringUtils.isEmpty(user.getPassword())) {
			errors.rejectValue("password",null,"Please Enter Password...");
		}
		

		if(StringUtils.isEmpty(user.getRoles())) {
			errors.rejectValue("roles",null,"Please Enter at least one Role...");
		}
	
	}
	
}
