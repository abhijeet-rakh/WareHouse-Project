package com.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelview.WhUserTypeExcelView;
import com.app.excelview.WhUserTypeExcelViewById;
import com.app.model.WhUserType;
import com.app.pdfview.WhUserTypePdfView;
import com.app.pdfview.WhUserTypePdfViewById;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;

@Controller
@RequestMapping("/wtype")
public class WhUserTypeController {

	@Autowired
	private WhUserTypeValidator validator;

	@Autowired
	private IWhUserTypeService service;

	// show Register Page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("whUserType",new WhUserType());
		return "WhUserTypeRegister";
	}
	
	//2. insert data
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String save(@ModelAttribute WhUserType whUserType,Errors errors, ModelMap map) {
		//calling validator
	  	validator.validate(whUserType, errors);
		//b- check for errors
		if(errors.hasErrors()) {
			//if error exist
			map.addAttribute("message","Please check all Errors");
		}else {
			//no errors
			int wwid = service.saveWhUserType(whUserType);
			map.addAttribute("message","Saved with Id:"+wwid);
			// call service layer save method.
			map.addAttribute("whUserType",new WhUserType());
		}
		return "WhUserTypeRegister";
	}
	
	//3.retrieve the data
	@RequestMapping(value="/all")
	public String getAll(ModelMap map) {
		List<WhUserType> list = service.getAllWhUserTypes();		
		map.addAttribute("data",list);
		return "WhUserTypeData";
	}
	
	
	//4.delete data by Id
	@RequestMapping(value="/delete")
	public String deleteWhUser(@RequestParam Integer wid,ModelMap map) {
		service.deleteWhUserType(wid);
		map.addAttribute("data", service.getAllWhUserTypes());
		map.addAttribute("message",wid+" Number Record Deleted");
		return "WhUserTypeData";
	}
	
	
	//5.View data by Id
	@RequestMapping(value="/viewOne")
	public String viewWhUser(@RequestParam Integer wid,ModelMap map) {
		map.addAttribute("li",service.getWhUserTypeById(wid));		
		return "WhUserTypeView";
	}
	
	@RequestMapping(value="/editOne")
	public String editWhUser(@RequestParam Integer wid,ModelMap map) {
		map.addAttribute("whUserType",service.getWhUserTypeById(wid));
		return "WhUserTypeEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateWhUser(@ModelAttribute  WhUserType whUserType,ModelMap map) {
	    service.updateWhUserType(whUserType);
		map.addAttribute("data",service.getAllWhUserTypes());
		return "WhUserTypeData";
	}
	
	@RequestMapping(value="/excelOne")
	public ModelAndView excelOneWhUserType(@RequestParam Integer wid) {
		WhUserType wu=service.getWhUserTypeById(wid);
		return new ModelAndView(new WhUserTypeExcelViewById(),"onedata",Arrays.asList(wu));
	}
	
	@RequestMapping(value="/excelall")
	public ModelAndView excelAllWhUserType() {
		List<WhUserType> list=service.getAllWhUserTypes();
		return new ModelAndView(new WhUserTypeExcelView(),"list",list);
	}
	
	@RequestMapping(value="/pdfOne")
	public ModelAndView pdfOneWhUserType(@RequestParam Integer wid) {
		WhUserType wut=service.getWhUserTypeById(wid);
		return new ModelAndView(new WhUserTypePdfViewById(),"onedata",Arrays.asList(wut));
	}
	
	@RequestMapping(value="/pdfall")
	public ModelAndView pdfAllWhUserType() {
		List<WhUserType> list=service.getAllWhUserTypes();
		return new ModelAndView(new WhUserTypePdfView(),"list",list);
	}
	
}
