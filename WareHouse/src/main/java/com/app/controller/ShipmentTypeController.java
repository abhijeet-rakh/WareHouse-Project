package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    	System.out.println("Controller=");
    	System.out.println("desc="+shiptype.getDesc()+"  "+shiptype.getEnableShipment()+" "+shiptype.getId()+"  "+shiptype.getShipmentCode()+"  "+shiptype.getShipmentGrade()+shiptype.getShipmentMode()+" "+shiptype.getShipmentMode());
    	
		id=service.saveShipmentType(shiptype);
    	
		message="Your registration No is="+id;
    	
		map.addAttribute("msg", message);
		
    	return "ShipmentTypeRegister";
    }
    
    
    @RequestMapping(value="/all")
    public String getAllShipmentType(ModelMap map) {
    	List<ShipmentType> list=service.getAllShipmentType();
    	map.addAttribute("data",list);
    	return "ShipmentTypeData";
    }
    
    @RequestMapping(value="delete")
    public String deleteShipmentType(@RequestParam("sid") Integer id,ModelMap map) {
    	service.deleteShipmentType(id);
    	
    	String msg="deleted "+id+" number record";
    	
    	//add msg to map
    	map.addAttribute("message",msg);

    	//get record form database
    	List<ShipmentType> list=service.getAllShipmentType();
    	
    	//add to map
    	map.addAttribute("data",list);
    	return "ShipmentTypeData";
    }

}
