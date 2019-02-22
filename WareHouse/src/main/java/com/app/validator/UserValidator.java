package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.User;
import com.app.service.IUserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private IUserService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user=(User) target;
		
		if(StringUtils.isEmpty(user.getUserName())) {
			errors.rejectValue("userName",null,"Please Enter Username...");
		}else if(!Pattern.matches("[a-z]{4,8}",user.getUserName())) {
			errors.rejectValue("userName",null,"Please Enter username in lowercase having 4 to 8 letters...");
		}
		
		if(StringUtils.isEmpty(user.getMail())) {
			errors.rejectValue("mail",null,"Please Enter mail...");
		}
		
		/*else if(service.isEmailExist("mail",user.getMail())) {
			errors.rejectValue("mail",null,"Already Email Exists...");
		}*/
		
		if(StringUtils.isEmpty(user.getMobile())) {
			errors.rejectValue("mobile",null,"Please Enter mobile...");
		}
		
		/*else if(service.isMobileExist("mobile",user.getMobile())){
			errors.rejectValue("mobile",null,"Please Enter mobile...");
		}*/
		
		if(StringUtils.isEmpty(user.getPassword())) {
			errors.rejectValue("password",null,"Please Enter Password...");
		}
		
		if(StringUtils.isEmpty(user.getRoles())) {
			errors.rejectValue("roles",null,"Please Enter at least one Role...");
		}
	
	}
	
}
