package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	
    @RequestMapping(value="/register")
	public String showRegister() {
		return "ShipmentTypeRegister";
	}
	
    @RequestMapping(value="/insert",method=RequestMethod.POST)
    public String addShipmentType(@ModelAttribute ShipmentType shiptype,ModelMap map) {
		Integer id=null;
    	String message=null;
    	
		id=service.saveShipmentType(shiptype);
    	
		message="Your registration No is="+id;
    	
		map.addAttribute("msg", message);
		
    	return "ShipmentTypeRegister";
    }
    
}
