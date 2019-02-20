package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ShipmentType st=(ShipmentType) target;
		
		
		if(StringUtils.isEmpty(st.getShipmentMode())) {
			errors.rejectValue("shipmentMode",null,"Enter Shipment Mode...");
		}
		
		
		if(StringUtils.isEmpty(st.getShipmentCode())) {
			errors.rejectValue("shipmentCode",null,"Enter Shipment Code...");
		}else if(!Pattern.matches("[A-Z]{4,8}",st.getShipmentCode())) {
			errors.rejectValue("shipmentCode",null,"Shipment Code should be Uppercase and between 4 to 8 range...");
		}
        
		
		if(StringUtils.isEmpty(st.getEnableShipment())) {
			errors.rejectValue("enableShipment",null,"Enter Yes or No...");
		}
	    
		
		if(StringUtils.isEmpty(st.getShipmentGrade())) {
			errors.rejectValue("shipmentGrade",null,"Enter the Grade here...");
		}
		
		if(StringUtils.isEmpty(st.getDesc())) {
			errors.rejectValue("desc",null,"Enter the Description...");
		}else if(st.getDesc().length()>5 && st.getDesc().length()<10){
			errors.rejectValue("desc",null,"Enter 5 to 10 letters in text...");
		}
		
	}

}
