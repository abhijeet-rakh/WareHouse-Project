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

import com.app.excelview.UOMTypeExcelView;
import com.app.excelview.UOMTypeExcelViewById;
import com.app.model.UOM;
import com.app.pdfview.UOMTypePdfView;
import com.app.pdfview.UOMTypePdfViewById;
import com.app.service.IUOMTypeService;
import com.app.util.UOMtypeUtility;
import com.app.validator.UOMTypeValidator;

@Controller
@RequestMapping(value="/uom")
public class UOMTypeController {

	//@Autowired
	//private UOMTypeValidator validator;

	@Autowired
	private IUOMTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private UOMtypeUtility utility;

	@RequestMapping(value = "/register")
	public String regUOMType(ModelMap map) {

		// add new Object to map
		map.addAttribute("uom", new UOM());

		return "UOMTypeRegister";
	}

	@RequestMapping(value="/insert",method =RequestMethod.POST)
	public String saveUOMType(@ModelAttribute UOM uom, Errors errors, ModelMap map) {

		//validate the UOM
		//validator.validate(uom, errors);

		if (errors.hasErrors()) {
             //If Error is there
			map.addAttribute("message","Please Check Errors.......");
		} else {
             //If Error is not there
			Integer id = service.saveUOMtype(uom);

			String msg = "record '"+id+"'inserted";

			map.addAttribute("message", msg);

			// clean previous object and add new to spring form tag map
			map.addAttribute("uom", new UOM());
		}
		return "UOMTypeRegister";
	}

	@RequestMapping(value = "/all")
	public String getAllUOMtype(ModelMap map) {
		List<UOM> list = service.getAllUOMtype();

		map.addAttribute("data", list);

		return "UOMTypeData";

	}

	@RequestMapping("/delete")
	public String deleteUOMtypeById(@RequestParam("uid") Integer id, ModelMap map) {
		service.deleteUOMById(id);

		String msg = id + " number record deleted";

		map.addAttribute("message", msg);
		// get record again
		List<UOM> list = service.getAllUOMtype();

		// add data to map
		map.addAttribute("data", list);

		return "UOMTypeData";

	}

	@RequestMapping("viewOne")
	public String getUOMtypeById(@RequestParam Integer uid, ModelMap map) {
		UOM uom = service.getUOMtypeById(uid);

		map.addAttribute("um", uom);

		return "UOMTypeView";
	}

	@RequestMapping("editOne")
	public String editUOMtype(@RequestParam Integer uid, ModelMap map) {

		map.addAttribute("UOM", service.getUOMtypeById(uid));

		return "UOMTypeEdit";
	}

	@RequestMapping("update")
	public String updateUOMtype(@ModelAttribute UOM uom, ModelMap map) {

		service.updateUOMtype(uom);

		map.addAttribute("message", "updated " + uom.getUomid() + " Record");

		map.addAttribute("data", service.getAllUOMtype());

		return "UOMTypeData";
	}

	@RequestMapping("excelExp")
	public ModelAndView getAllUOMTypeforExcel() {
		List<UOM> list = service.getAllUOMtype();
		return new ModelAndView(new UOMTypeExcelView(), "list", list);
	}

	@RequestMapping("excelOne")
	public ModelAndView getUOMTypeByIdforExcel(@RequestParam Integer uid) {
		UOM uom = service.getUOMtypeById(uid);
		return new ModelAndView(new UOMTypeExcelViewById(), "onedata", Arrays.asList(uom));
	}

	@RequestMapping("pdfExp")
	public ModelAndView getAllUOMTypeforPdf() {
		List<UOM> list = service.getAllUOMtype();
		return new ModelAndView(new UOMTypePdfView(), "list", list);
	}

	@RequestMapping("pdfOne")
	public ModelAndView getUOMTypeByIdforPdf(@RequestParam Integer uid) {
		UOM uom = service.getUOMtypeById(uid);
		return new ModelAndView(new UOMTypePdfViewById(), "onedata", Arrays.asList(uom));
	}

	@RequestMapping("report")
	public String getUOMTypeCount() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getUOMtypeCount();
		utility.generatePieChart(path, list);
		utility.generateBarChart(path, list);
		return "UOMtypeCountReport";
	}

}