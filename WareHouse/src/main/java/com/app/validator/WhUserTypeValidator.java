package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Component
public class WhUserTypeValidator implements Validator{
	
	@Autowired
	private IWhUserTypeService whservice;

	@Override
	public boolean supports(Class<?> clz) {
		return WhUserType.class.equals(clz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WhUserType whUserType=(WhUserType)target;
		
		/** DropDown empty checks*/
		if(StringUtils.isEmpty(whUserType.getWhType())) {
			errors.rejectValue("whType",null,"Please choose one Type !!");
		}
		
		//Text Input
		//a. Empty check     (b). pattern check				
		if(!Pattern.matches("[A-Z]{4,6}", whUserType.getWhCode())) {
			errors.rejectValue("whCode", null, "Enter WhUser Code in uppercase between 4 to 6 ...!");
		}else if(whservice.isWhUserCodeExist(whUserType.getWhCode())) {
			errors.rejectValue("whCode", null, "WareHouse Code Exists already...!");		
		}

		/** DropDown empty checks*/
		if(StringUtils.isEmpty(whUserType.getWhIdType())) {
			errors.rejectValue("whIdType",null,"Please choose one...!");
		}
		
		/** Test input */
		//a. Empty check     (b). pattern check
		if(!StringUtils.hasText(whUserType.getWhContact())) {
			errors.rejectValue("whContact", null, "Enter Reference Number...!");
		}
		else if(!Pattern.matches("[1-9]{7,10}",whUserType.getWhContact())) {
			errors.rejectValue("whContact", null, "Number must be between 7-10 digit !!");
		}

		/** Test input */
		//a. Empty check     (b). pattern check
		if(!StringUtils.hasText(whUserType.getWhIdNumber())) {
			errors.rejectValue("whIdNumber", null, "Enter Reference Number !!");
		}
		else if(!Pattern.matches("[0-9]{5,16}",whUserType.getWhIdNumber())) {
			errors.rejectValue("whIdNumber", null, "Number must be 5-16 digit !!");
		}

		/** DropDown empty checks*/
		if(StringUtils.isEmpty(whUserType.getWhFor())) {
			errors.rejectValue("whFor",null,"Please choose one !!");
		}
		
		/** Test-area */
		//a. has no Test     (b). size check
		if(!StringUtils.hasText(whUserType.getWhEmail())) {
			errors.rejectValue("whEmail",null,"Enter a Email !!");
		}
		else if(whservice.isEmailOrMobileExists(whUserType.getWhEmail())) {
			errors.rejectValue("whEmail",null,"Entered Email is Exists...!");
		}
		
	}

}
