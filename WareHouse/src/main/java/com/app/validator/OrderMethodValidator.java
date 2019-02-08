package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod orderMethod = (OrderMethod) target;

		/*Order Mode*/
		if (StringUtils.isEmpty(orderMethod.getOrdermode())) {
			errors.rejectValue("ordermode", null, "Please Enter OrderMode.....");
		}

		/*Order Method*/
	    if(!StringUtils.hasText(orderMethod.getOrdercode())) {
	    	errors.rejectValue("ordercode",null,"Please Enter Code !!");
	    }else if(!Pattern.matches("[A-Z]{3,5}",orderMethod.getOrdercode())){
	    	errors.rejectValue("ordercode",null,"Please Enter in Uppercase and numbering in 3 to 5......");
	    }
        
	    /*Execute Type*/
	    if(StringUtils.isEmpty(orderMethod.getExecutetype())) {
	    	errors.rejectValue("executetype",null,"Please Enter Execution Type.......");
	    }
	    
	    /*Order Accept*/
	    if(orderMethod.getOrderaccept()== null || orderMethod.getOrderaccept().isEmpty()) {
	        errors.rejectValue("orderaccept",null,"Please Enter OrderAccept..........");	
	    }
	    
	    /*Description */
	    if(StringUtils.hasText(orderMethod.getDesc())) {
	    	errors.rejectValue("dsc",null,"Please Enter Description.........");
	    }else if(orderMethod.getDesc().length()>10 && orderMethod.getDesc().length()<50) {
	    	errors.rejectValue("",null,"");
	    }
	    
	}
}
