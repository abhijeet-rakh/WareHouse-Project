package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;

@Component
public class PurchaseOrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder po=(PurchaseOrder) target;
	
		/*validation for Purchase Order Code*/
		if(!StringUtils.hasText(po.getOrderCode())) {
			errors.rejectValue("orderCode",null,"Please Enter Purchase OrderCode...");
		}else if(!Pattern.matches("[A-Z]{4,6}",po.getOrderCode())){
			errors.rejectValue("orderCode",null,"Please Enter 4 to 6 chars in Uppercase only...");
		}
	
		/*  ShipmentMode*/
		if(StringUtils.isEmpty(po.getShiptype())) {
			errors.rejectValue("shiptype",null,"Please Enter at least one Shipment Code...");
		}
		
		/* Vendor*/
		if(StringUtils.isEmpty(po.getWhusertype())) {
			errors.rejectValue("whusertype",null,"Please Enter at least one Vendor...");
		}
		
		/*Ref Number*/
		if(!StringUtils.hasText(po.getRefNum())) {
			errors.rejectValue("refNum",null,"Please Enter RefNum...");
		}else if(!Pattern.matches("[0-9]{6,8}",po.getRefNum())) {
			errors.rejectValue("refNum",null,"Please Enter RefNum in Number and 6 to 8 chars only...");
		}
		
		/*qualityCheck*/
		if(!StringUtils.hasLength(po.getQualityCheck())) {
			errors.rejectValue("qualityCheck",null,"Please at least choose one option...");
		}
		
		if(!StringUtils.hasText(po.getOrdDesc())) {
			errors.rejectValue("ordDesc",null,"Please Enter OrderDesc...");
		}
		
	}

}
