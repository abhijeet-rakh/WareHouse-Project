package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.UnitOfMeasurement;

@Component
public class UnitOfMeasurementTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UnitOfMeasurement.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UnitOfMeasurement UnitOfMeasurement = (UnitOfMeasurement) target;

		if (StringUtils.isEmpty(UnitOfMeasurement.getUomType())) {
			errors.rejectValue("uomType", null, "Please Enter UnitOfMeasurement Type...");
		}

		if (StringUtils.isEmpty(UnitOfMeasurement.getUomModel())) {
			errors.rejectValue("uomModel", null, "Please Enter UnitOfMeasurement Model...");
		}

		if (StringUtils.isEmpty(UnitOfMeasurement.getUomDesc())) {
			errors.rejectValue("uomDesc", null, "Enter data in Description...");
		} else if (UnitOfMeasurement.getUomDesc().length() > 10 && UnitOfMeasurement.getUomDesc().length() < 50) {
			errors.rejectValue("uomDesc", null, "Enter 10 to 50 letters in Description...");
		}

	}

}
