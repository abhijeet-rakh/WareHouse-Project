package com.app.validator;

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
			errors.rejectValue("shipmentMode",null,"Enter Shipment Code....");
		}
		
		if(StringUtils.isEmpty(st.getShipmentCode())) {
			errors.rejectValue("shipmentCode",null,"Enter Shipment Code......");
		}
		
		
		if(StringUtils.isEmpty(st.getEnableShipment())) {
			errors.rejectValue("enableShipment",null,"Enable or Disable Shipment......");
		}
		
		if(StringUtils.isEmpty(st.getShipmentGrade())) {
			errors.rejectValue("shipmentGrade",null,"Enter the Grade here....");
		}
		
		if(StringUtils.isEmpty(st.getDesc())) {
			errors.rejectValue("desc",null,"Enter the Description.......");
		}else if(st.getDesc().length()>10 && st.getDesc().length()<50) {
			errors.rejectValue("desc",null,"Enter 10 to 50 letters in text.....");
		}
		

	}

}
