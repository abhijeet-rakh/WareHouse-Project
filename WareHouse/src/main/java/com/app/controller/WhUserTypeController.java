package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelview.WhUserTypeUserTypeExcelView;
import com.app.excelview.WhUserTypeUserTypeExcelViewById;
import com.app.model.OrderMethod;
import com.app.model.WhUserType;
import com.app.pdfview.WhUserTypePdfView;
import com.app.pdfview.WhUserTypePdfViewById;
import com.app.service.IWhuserTypeService;
import com.app.util.WhUserTypeUtility;

@Controller
@RequestMapping(value = "whusertype")
public class WhUserTypeController {

	@Autowired
	private IWhuserTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private WhUserTypeUtility utility;
	
	
	@RequestMapping(value = "register")
	public String showregformWhUserType(ModelMap map) {
		map.addAttribute("WUT", new WhUserType());
		return "WhUserTypeRegister";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String savedataWhUserType(@ModelAttribute WhUserType wut, ModelMap map) {
		service.saveWhusertype(wut);

		// add message to map
		map.addAttribute("message", "added " + wut.getWhid() + " number record");

		// clean and add fresh object to map
		map.addAttribute("WUT", new WhUserType());

		return "WhUserTypeRegister";
	}

	@RequestMapping(value = "all")
	public String getAllWhUserType(ModelMap map) {
		map.addAttribute("data", service.getAllWhuserType());
		return "WhUserTypeData";
	}

	@RequestMapping(value = "viewOne")
	public String viewUserType(@RequestParam Integer wid, ModelMap map) {

		map.addAttribute("wut", service.getWhusertypeById(wid));

		return "WhUserTypeView";
	}

	@RequestMapping("editOne")
	public String editUserType(@RequestParam Integer wid, ModelMap map) {

		map.addAttribute("WUT", service.getWhusertypeById(wid));

		return "WhUserTypeEdit";
	}

	@RequestMapping("update")
	public String updateUserType(@ModelAttribute WhUserType wut, ModelMap map) {

		service.updateWhusertype(wut);

		map.addAttribute("message", "Record " + wut.getWhid() + " updated");

		map.addAttribute("data", service.getAllWhuserType());

		return "WhUserTypeData";
	}

	@RequestMapping("delete")
	public String deleteUserType(@RequestParam Integer wid, ModelMap map) {

		service.deleteWhusertype(wid);

		map.addAttribute("data", service.getAllWhuserType());

		map.addAttribute("message", "deleted " + wid + " Record");

		return "WhUserTypeData";
	}

	@RequestMapping("excelAll")
	public ModelAndView getAllWhUserTypeforExcel() {
		List<WhUserType> list = service.getAllWhuserType();

		return new ModelAndView(new WhUserTypeUserTypeExcelView(), "list", list);
	}

	@RequestMapping("excelOne")
	public ModelAndView getWhUserTypeByIdforExcel(@RequestParam Integer wid) {
		WhUserType wut = service.getWhusertypeById(wid);

		return new ModelAndView(new WhUserTypeUserTypeExcelViewById(), "wut", Arrays.asList(wut));
	}

	@RequestMapping("pdfExp")
	public ModelAndView getAllWhUserTypeforPdf() {
		List<WhUserType> list = service.getAllWhuserType();

		return new ModelAndView(new WhUserTypePdfView(), "list", list);
	}

	@RequestMapping("pdfOne")
	public ModelAndView getWhUserTypeByIdById(@RequestParam Integer wid) {
		WhUserType wut = service.getWhusertypeById(wid);

		return new ModelAndView(new WhUserTypePdfViewById(), "onedata", Arrays.asList(wut));
	}

	@RequestMapping("report")
	public String getWhUserType() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getWhUserTypeCount();
        utility.generate(path, list);
		return "WhUserTypeReport";
	}

	
}
