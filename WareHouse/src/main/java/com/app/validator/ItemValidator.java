package com.app.validator;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Item im = (Item) target;

		if (StringUtils.isEmpty(im.getItemCode())) {
			errors.rejectValue("itemCode", null, "Please Enter Item Code...");
		} 

		System.out.println(im.getItemLength());
		if (StringUtils.isEmpty(im.getItemLength())) {
			errors.rejectValue("itemLength", null, "Please Enter Item Length...");
		}

		if (StringUtils.isEmpty(im.getItemWidth())) {
			errors.rejectValue("itemWidth", null, "Please Enter ItemWidth...");
		}
		
		if (StringUtils.isEmpty(im.getItemHeight())) {
			errors.rejectValue("itemHeight", null, "Please Enter Item Height...");
		} 
		
		if (StringUtils.isEmpty(im.getBaseCost())) {
			errors.rejectValue("baseCost", null, "Please Enter Base Cost...");
		} 

		if(!StringUtils.hasText(im.getBaseCurrency())) {
			errors.rejectValue("baseCurrency",null,"Please Enter at least one currency...");
		}
		
		if (StringUtils.isEmpty(im.getItemDesc())) {
			errors.rejectValue("itemDesc", null, "Please Enter Description...");
		} 
	
	}

}
