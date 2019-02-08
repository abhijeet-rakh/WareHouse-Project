package com.app.validator;

import java.util.regex.Pattern;

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
		} else if (Pattern.matches("{A-Z}[4-6]", im.getItemCode())) {
			errors.rejectValue("itemCode", null, "Enter Item Code in Uppercase in between 0 to 5");
		}

		if (StringUtils.isEmpty(im.getItemLength())) {
			errors.rejectValue("itemLength", null, "Please Enter Item Length..");
		} else if (im.getItemLength() > 10 && im.getItemLength() < 50) {
			errors.rejectValue("itemLength", null, "Don't Enter Item Length between 10 to 50..");
		}

		if (StringUtils.isEmpty(im.getItemWidth())) {
			errors.rejectValue("itemWidth", null, "Please Enter ItemWidth...");
		} else if (im.getItemWidth() > 10 && im.getItemWidth() < 50) {
			errors.rejectValue("itemWidth", null, "Don't Enter Item Width between 10 t0 50");
		}

		if (StringUtils.isEmpty(im.getItemHeight())) {
			errors.rejectValue("itemHeight", null, "Please Enter Item Height.....");
		} else if (im.getItemHeight() > 10 && im.getItemHeight() < 50) {
			errors.rejectValue("itemHeight", null, "Donn't Enter Height between 10 to 50....");
		}

		if (StringUtils.isEmpty(im.getBaseCost())) {
			errors.rejectValue("baseCost", null, "Please Enter Base Cost...");
		} else if (im.getItemLength() < 500) {
			errors.rejectValue("baseCost", null, "Please do not Enter Base Cost below 500...");
		}

		if(!StringUtils.hasText(im.getBaseCurrency())) {
			errors.rejectValue("baseCurrency",null,"Please Enter at least one currency...");
		}
		
		if (StringUtils.isEmpty(im.getItemDesc())) {
			errors.rejectValue("itemDesc", null, "Please Enter Description...");
		} else if (im.getItemDesc().length() > 10 && im.getItemDesc().length() <100) {
			errors.rejectValue("itemDesc", null, "Please Enter 10 to 100 letters...");
		}

	}

}
