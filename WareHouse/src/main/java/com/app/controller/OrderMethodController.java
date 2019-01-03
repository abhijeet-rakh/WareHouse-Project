package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Controller
@RequestMapping(value="/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	
	@RequestMapping(value="/register")
	public String regOrderMethod(ModelMap map) {
		map.addAttribute("OM",new OrderMethod());
		return "OrderMethodRegister";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String saveOrderMethod(@ModelAttribute OrderMethod om,ModelMap map) {
		
		System.out.println(" "+om.getDesc()+"  "+om.getExecutetype()+" "+om.getOrdercode()+"  "+om.getOrdermode()+"  "+om.getOrderaccept()+" "+om.getOid());
    	
		Integer id=service.saveOrderMethod(om);
		
		String msg="record inserted no is "+id;
	
		//add attribute to map
		map.addAttribute("message",msg);
		
		//clean the object 
		map.addAttribute("OM",new OrderMethod());
		
		return "OrderMethodRegister";
	}
	
	@RequestMapping(value="all")
	public String getAllOrderMethod(ModelMap map) {
		List<OrderMethod> list=service.getAllOrderMethod();
		
		map.addAttribute("data",list);
		return "OrderMethodData";
	}
	
	@RequestMapping(value="delete")
	public String deleteOrderMethod(@RequestParam("oid") Integer id,ModelMap map) {
	    service.deleteOrderMethod(id);
	
	    String msg="deleted "+id+" number record";
	    
	    map.addAttribute("message",msg);
	
	    //again get element back 
	    List<OrderMethod> list=service.getAllOrderMethod();
		
	    //add data to map
		map.addAttribute("data",list);
	
	    return "OrderMethodData";
	}
	
	@RequestMapping(value="viewOne")
	public String getOrderMethodById(@RequestParam Integer oid,ModelMap map) {
		
		OrderMethod ordermeth=service.getOrderMethodById(oid);
          		
		map.addAttribute("om",ordermeth);
		
		return "OrderMethodView";
	}
	
	
}
