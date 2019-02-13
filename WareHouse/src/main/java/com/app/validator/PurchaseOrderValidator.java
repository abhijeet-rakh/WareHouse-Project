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
		
		/*validation for Order Code*/
		if(!StringUtils.hasText(po.getOrderCode())) {
			errors.rejectValue("orderCode",null,"Please Enter OrderCode...");
		}else if(po.getOrderCode().length()>4 && po.getOrderCode().length()<6){
			errors.rejectValue("orderCode",null,"Please Enter 4 to 6 chars only...");
		}
	
		/*  ShipmentMode*/
		if(!StringUtils.hasText(po.getShiptype().getShipmentCode())) {
			errors.rejectValue("shiptype",null,"Please Enter at least one Shipment Mode...");
		}
		
		/* Vendor*/
		if(!StringUtils.hasText(po.getWhusertype().getUserCode())) {
			errors.rejectValue("whusertype",null,"Please Enter at least one Vendor...");
		}
		
		/*Ref Number*/
		if(!StringUtils.hasText(po.getRefNum())) {
			errors.rejectValue("refNum",null,"Please Enter RefNum...");
		}else if((!Pattern.matches("[A-Z]", po.getRefNum())) && (po.getRefNum().length()>8 && po.getRefNum().length()<12)) {
			errors.rejectValue("refNum",null,"Please Enter RefNum in uppercase and 8 to 12 chars only...");
		}
		
		/*qualityCheck*/
		if(!StringUtils.hasLength(po.getQualityCheck())) {
			errors.rejectValue("qualityCheck",null,"Please at least choose one option...");
		}
		
		if(!StringUtils.hasText(po.getOrdDesc())) {
			errors.rejectValue("ordDesc",null,"Please Enter OrderDesc...");
		}else if(po.getOrdDesc().length()>10 && po.getOrdDesc().length()<100){
			errors.rejectValue("ordDesc",null,"Please Enter 10 to 100 chars...");
		}
		
	}

}
