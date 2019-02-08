package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;

@Component
public class WhUserTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
          
		WhUserType wht=(WhUserType) target;
				
		if(StringUtils.hasText(wht.getUserCode())) {
			errors.rejectValue("userCode",null,"Please Enter Code of User.....");
		}else if(Pattern.matches("[A-Z]{5,7}",wht.getUserCode())) {
			errors.rejectValue("userCode",null,"please Enter code in Uppercase and number in 5 to 7......");
		}
		
		if(StringUtils.isEmpty(wht.getUserFor())) {
			errors.rejectValue("userFor",null,"Please Enter User For.........");
		}
		
		if(StringUtils.isEmpty(wht.getUserEmail())) {
			errors.rejectValue("userEmail",null,"Please Enter a Mail....");
		}
		
		if(StringUtils.isEmpty(wht.getUserContact())) {
			errors.rejectValue("userContact",null,"Please Enter contact Number....");
		}

		if(StringUtils.isEmpty(wht.getUserIdType())) {
			errors.rejectValue("userIdType",null,"Please Enter UserId Type.........");
		}
		
		if(StringUtils.isEmpty(wht.getWhid())) {
			errors.rejectValue("idnumber",null,"Please Enter WareHouse User Id");
		}
		
	}

}
