package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.WhUserType;
import com.app.service.IWhuserTypeService;

@Controller
@RequestMapping(value="whusertype")
public class WhUserTypeController {

	 @Autowired
     private IWhuserTypeService service;
	
	 @RequestMapping(value="register")
	 public String showregformWhUserType(ModelMap map) {
		 map.addAttribute("WUT",new WhUserType());
		 return "WhUserTypeRegister";
	 }

	 
	 @RequestMapping(value="insert",method=RequestMethod.POST)
	 public String savedataWhUserType(@ModelAttribute WhUserType wut,ModelMap map) {
		 service.saveWhusertype(wut);
		 
		 //add message to map
		 map.addAttribute("message","added "+wut.getWhid()+" number record");
		 
		 //clean and add fresh object to map
		 map.addAttribute("WUT",new WhUserType());
		 
		 return "WhUserTypeRegister";
	 }
	 
	 
	 @RequestMapping(value="all")
	 public String getAllWhUserType(ModelMap map) {
 		 map.addAttribute("data",service.getAllWhuserType());
 		 return "WhUserTypeData";
	 }
	 
	 @RequestMapping(value="viewOne")
	 public String viewUserType(@RequestParam Integer wid,ModelMap map) {
		 
		 map.addAttribute("wut",service.getWhusertypeById(wid));
		 	 
		return "WhUserTypeView";
	 }
	 
	 
	 @RequestMapping("editOne")
	 public String editUserType(@RequestParam Integer wid,ModelMap map) {
		 
		map.addAttribute("WUT",service.getWhusertypeById(wid));
		 
		 return "WhUserTypeEdit";
	 }
	 
	 @RequestMapping("update")
	 public String updateUserType(@ModelAttribute WhUserType wut,ModelMap map) {
		 
		 service.updateWhusertype(wut);
		 
		 map.addAttribute("message","Record "+wut.getWhid()+" updated");
		 
		 map.addAttribute("data",service.getAllWhuserType());
		
		 return "WhUserTypeData";
	 }
	 
	 @RequestMapping("delete")
	 public String deleteUserType(@RequestParam Integer wid,ModelMap map) {
		 
		 service.deleteWhusertype(wid);
		 
		 map.addAttribute("data",service.getAllWhuserType());
		 
		 map.addAttribute("message","deleted "+wid+" Record");
		 
		 return "WhUserTypeData";
	 }
}
