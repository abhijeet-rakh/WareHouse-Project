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
			errors.rejectValue("ordermode", null, "Please Enter OrderMode...");
		}

		/*Order Method*/
	    if(!StringUtils.hasText(orderMethod.getOrdercode())) {
	    	errors.rejectValue("ordercode",null,"Please Enter Code...");
	    }
	    
	    /*Execute Type*/
	    if(StringUtils.isEmpty(orderMethod.getExecutetype())) {
	    	errors.rejectValue("executetype",null,"Please Enter Execution Type...");
	    }
	    
	    /*Order Accept*/
	    if(orderMethod.getOrderaccept()== null || orderMethod.getOrderaccept().isEmpty()) {
	        errors.rejectValue("orderaccept",null,"Please Enter OrderAccept...");	
	    }
	    
	    /*Description */
	    if(!StringUtils.hasText(orderMethod.getOrderdesc())) {
	    	errors.rejectValue("orderdesc",null,"Please Enter Description...");
	    }
	    
	}
}
