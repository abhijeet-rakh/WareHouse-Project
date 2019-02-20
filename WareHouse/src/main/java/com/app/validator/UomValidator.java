package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;

@Component
public class UomValidator implements Validator {

	@Autowired
	private IUomService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// down cast to model class object
		Uom om = (Uom) target;

		if (!Pattern.compile("[A-Z]{4,9}").matcher(om.getUomModel()).matches()) {
			errors.rejectValue("uomModel", null, "Enter 4 9 Char in Uppercase Valid Uom");
		}else if (service.isUomModelExist(om.getUomModel())) {
			System.out.println("error count isUomModelExist="+errors.getErrorCount());
			errors.rejectValue("uomModel", null, "Uom Already Exist Please use some other Model");
		}

		if (om.getUomType() == null || "".equals(om.getUomType())) {
            
			errors.rejectValue("uomType", null, "Please choose one Type");
		}

		// check boxes and multi-select dropdown

		/*
		 * if(!Pattern.compile("{4,10}").matcher(om.getUomDsc()).matches()) {
		 *        errors.rejectValue("uomDsc", null,
		 *        "Enter Valid code(4 to 100  char Uppercase only)");
		 * 
		 * }
		 * 
		 */

	}
}
