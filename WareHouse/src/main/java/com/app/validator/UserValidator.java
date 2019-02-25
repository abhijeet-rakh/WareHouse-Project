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

	private static final String PASSWORD_PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$";
	
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
		}else if(service.isuserNameExist(user.getUserName())){
			errors.rejectValue("userName",null,"Username already Exists Please Enter another...");
		}
		
		if(StringUtils.isEmpty(user.getMail())) {
			errors.rejectValue("mail",null,"Please Enter mail...");
		}else if(service.isEmailExist(user.getMail())) {
			errors.rejectValue("mail",null,"Email already Exists...");
		}
		
		if(StringUtils.isEmpty(user.getMobile())) {
			errors.rejectValue("mobile",null,"Please Enter mobile...");
		}else if(service.isMobileExist(user.getMobile())){
			errors.rejectValue("mobile",null,"Mobile already Exists...");
		}
		
		/*
		^                 # start-of-string
		(?=.*[0-9])       # a digit must occur at least once
		(?=.*[a-z])       # a lower case letter must occur at least once
		(?=.*[A-Z])       # an upper case letter must occur at least once
		(?=.*[@#$%^&+=])  # a special character must occur at least once
		(?=\S+$)          # no whitespace allowed in the entire string
		.{8,20}             # anything, at least eight places and max 20 places
		$                 # end-of-string
		
		?= – means apply the assertion condition, meaningless by itself, always work with other combination
		
		*/
		if(StringUtils.isEmpty(user.getPassword())) {
			errors.rejectValue("password",null,"Please Enter Password...");
		}
		/*else if(!Pattern.matches(PASSWORD_PATTERN,user.getPassword())) {
			errors.rejectValue("password",null,"Please Enter atleast one digit,lowercase letter,uppercase letter,special character,no whitesapces and 8 alphanumeric characters...");
		}
		*/
		
		System.out.println("roles="+user.getRoles());
		
		if(StringUtils.isEmpty(user.getRoles())) {
			errors.rejectValue("roles",null,"Please Enter at least one Role...");
		}
	
	}
	
}
