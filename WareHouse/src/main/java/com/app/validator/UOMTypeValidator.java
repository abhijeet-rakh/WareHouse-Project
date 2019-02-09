package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.UOM;

@Component
public class UOMTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UOM.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UOM uom = (UOM) target;

		if (StringUtils.isEmpty(uom.getUomtype())) {
			errors.rejectValue("uomtype", null, "Please Enter UOM Type...");
		}

		if (StringUtils.isEmpty(uom.getUommodel())) {
			errors.rejectValue("uommodel", null, "Please Enter UOM Model...");
		}

		if (StringUtils.isEmpty(uom.getUomdesc())) {
			errors.rejectValue("uomdesc", null, "Enter data in Description...");
		} else if (uom.getUomdesc().length() > 10 && uom.getUomdesc().length() < 50) {
			errors.rejectValue("uomdesc", null, "Enter 10 to 50 letters in Description...");
		}

	}

}
