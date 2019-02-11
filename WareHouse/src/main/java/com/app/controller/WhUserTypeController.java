package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelview.WhUserTypeUserTypeExcelView;
import com.app.excelview.WhUserTypeUserTypeExcelViewById;
import com.app.model.WhUserType;
import com.app.pdfview.WhUserTypePdfView;
import com.app.pdfview.WhUserTypePdfViewById;
import com.app.service.IWhuserTypeService;
import com.app.util.WhUserTypeUtility;
import com.app.validator.WhUserTypeValidator;

@Controller
@RequestMapping(value = "/whusertype")
public class WhUserTypeController {

	//@Autowired
	//private WhUserTypeValidator validator;
	
	@Autowired
	private IWhuserTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private WhUserTypeUtility utility;

	@RequestMapping(value = "/register")
	public String showregformWhUserType(ModelMap map) {
		map.addAttribute("whuserType", new WhUserType());
		return "WhUserTypeRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String savedataWhUserType(@ModelAttribute WhUserType whuserType,Errors errors, ModelMap map) {
		
		//validator.validate(whuserType, errors);
		
		System.out.println("Errors="+errors.hasErrors());
		System.out.println("Error count="+errors.getErrorCount());
		
		if(errors.hasErrors()) {
			
			System.out.println(errors.hasErrors());
			
		     map.addAttribute("message","Please Check all Errors.....");
		}else {
		
		service.saveWhusertype(whuserType);

		// add message to map
		map.addAttribute("message", "added " + whuserType.getWhid() + " number record");

		// clean and add fresh object to map
		map.addAttribute("whuserType", new WhUserType());

		}
		return "WhUserTypeRegister";
	}

	@RequestMapping(value = "/all")
	public String getAllWhUserType(ModelMap map) {
		map.addAttribute("data", service.getAllWhuserType());
		return "WhUserTypeData";
	}

	@RequestMapping(value = "/viewOne")
	public String viewUserType(@RequestParam Integer wid, ModelMap map) {

		map.addAttribute("whuserType", service.getWhusertypeById(wid));

		return "WhUserTypeView";
	}

	@RequestMapping("/editOne")
	public String editUserType(@RequestParam Integer wid, ModelMap map) {

		map.addAttribute("whuserType", service.getWhusertypeById(wid));

		return "WhUserTypeEdit";
	}

	@RequestMapping("/update")
	public String updateUserType(@ModelAttribute WhUserType whuserType, ModelMap map) {

		service.updateWhusertype(whuserType);

		map.addAttribute("message", "Record " + whuserType.getWhid() + " updated");

		map.addAttribute("data", service.getAllWhuserType());

		return "WhUserTypeData";
	}

	@RequestMapping("/delete")
	public String deleteUserType(@RequestParam Integer wid, ModelMap map) {

		service.deleteWhusertype(wid);

		map.addAttribute("data", service.getAllWhuserType());

		map.addAttribute("message", "deleted " + wid + " Record");

		return "WhUserTypeData";
	}

	@RequestMapping("/excelAll")
	public ModelAndView getAllWhUserTypeforExcel() {
		List<WhUserType> list = service.getAllWhuserType();

		return new ModelAndView(new WhUserTypeUserTypeExcelView(), "list", list);
	}

	@RequestMapping("/excelOne")
	public ModelAndView getWhUserTypeByIdforExcel(@RequestParam Integer wid) {
		WhUserType wut = service.getWhusertypeById(wid);

		return new ModelAndView(new WhUserTypeUserTypeExcelViewById(), "wut", Arrays.asList(wut));
	}

	@RequestMapping("/pdfExp")
	public ModelAndView getAllWhUserTypeforPdf() {
		List<WhUserType> list = service.getAllWhuserType();
		return new ModelAndView(new WhUserTypePdfView(), "list", list);
	}

	@RequestMapping("/pdfOne")
	public ModelAndView getWhUserTypeByIdById(@RequestParam Integer wid) {
		WhUserType wut = service.getWhusertypeById(wid);

		return new ModelAndView(new WhUserTypePdfViewById(), "onedata", Arrays.asList(wut));
	}

	@RequestMapping("/report")
	public String getWhUserType() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getWhUserTypeCount();
		utility.generatePieChart(path, list);
		utility.generateBarChart(path, list);
		return "WhUserTypeReport";
	}

}
