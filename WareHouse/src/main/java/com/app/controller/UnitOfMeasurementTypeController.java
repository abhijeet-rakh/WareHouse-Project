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

import com.app.excelview.UnitOfMeasurementTypeExcelView;
import com.app.excelview.UnitOfMeasurementTypeExcelViewById;
import com.app.model.UnitOfMeasurement;
import com.app.pdfview.UnitOfMeasurementTypePdfView;
import com.app.pdfview.UnitOfMeasurementTypePdfViewById;
import com.app.service.IUnitOfMeasurementTypeService;
import com.app.util.UnitOfMeasurementtypeUtility;
import com.app.validator.UnitOfMeasurementTypeValidator;

@Controller
@RequestMapping(value="/uom")
public class UnitOfMeasurementTypeController {

	public UnitOfMeasurementTypeController() {
	   System.out.println("UnitOfMeasurementTypeController:0 arg Constructor");
	}
 
	@Autowired
 	private UnitOfMeasurementTypeValidator validator;

	@Autowired
	private IUnitOfMeasurementTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private UnitOfMeasurementtypeUtility utility;

	@RequestMapping(value = "/register")
	public String regUnitOfMeasurementType(ModelMap map) {

		System.out.println("uom register");
		
		// add new Object to map
		map.addAttribute("unitmeasure", new UnitOfMeasurement());

		return "UnitOfMeasurementTypeRegister";
	}

	@RequestMapping(value="/insert",method =RequestMethod.POST)
	public String saveUnitOfMeasurementType(@ModelAttribute UnitOfMeasurement unitmeasure, Errors errors, ModelMap map) {

		//validate the UnitOfMeasurement
		validator.validate(unitmeasure, errors);

		if (errors.hasErrors()) {
             //If Error is there
			map.addAttribute("message","Please Check Errors.......");
		} else {
             //If Error is not there
			Integer id = service.saveUnitOfMeasurementtype(unitmeasure);

			String msg = "record '"+id+"'inserted";

			map.addAttribute("message", msg);

			// clean previous object and add new to spring form tag map
			map.addAttribute("unitmeasure", new UnitOfMeasurement());
		}
		return "UnitOfMeasurementTypeRegister";
	}
	
	
	@RequestMapping(value = "/all")
	public String getAllUnitOfMeasurementtype(ModelMap map) {
		List<UnitOfMeasurement> list = service.getAllUnitOfMeasurementtype();

		map.addAttribute("data", list);

		return "UnitOfMeasurementTypeData";

	}

	@RequestMapping("/delete")
	public String deleteUnitOfMeasurementtypeById(@RequestParam("uid") Integer id, ModelMap map) {
		service.deleteUnitOfMeasurementById(id);

		String msg = id + " number record deleted";

		map.addAttribute("message", msg);
		
		// get record again
		List<UnitOfMeasurement> list = service.getAllUnitOfMeasurementtype();

		// add data to map
		map.addAttribute("data", list);

		return "UnitOfMeasurementTypeData";

	}

	@RequestMapping("viewOne")
	public String getUnitOfMeasurementtypeById(@RequestParam Integer uid, ModelMap map) {
		UnitOfMeasurement UnitOfMeasurement = service.getUnitOfMeasurementtypeById(uid);

		map.addAttribute("unitmeasure",UnitOfMeasurement);

		return "UnitOfMeasurementTypeView";
	}

	@RequestMapping("editOne")
	public String editUnitOfMeasurementtype(@RequestParam Integer uid, ModelMap map) {

		map.addAttribute("unitmeasure", service.getUnitOfMeasurementtypeById(uid));

		return "UnitOfMeasurementTypeEdit";
	}

	@RequestMapping("update")
	public String updateUnitOfMeasurementtype(@ModelAttribute UnitOfMeasurement unitmeasure, ModelMap map) {

		service.updateUnitOfMeasurementtype(unitmeasure);

		map.addAttribute("message", "updated " + unitmeasure.getUomId() + " Record..");

		map.addAttribute("data", service.getAllUnitOfMeasurementtype());

		return "UnitOfMeasurementTypeData";
	}

	@RequestMapping("excelExp")
	public ModelAndView getAllUnitOfMeasurementTypeforExcel() {
		List<UnitOfMeasurement> list = service.getAllUnitOfMeasurementtype();
		return new ModelAndView(new UnitOfMeasurementTypeExcelView(), "list", list);
	}

	@RequestMapping("excelOne")
	public ModelAndView getUnitOfMeasurementTypeByIdforExcel(@RequestParam Integer uid) {
		UnitOfMeasurement UnitOfMeasurement = service.getUnitOfMeasurementtypeById(uid);
		return new ModelAndView(new UnitOfMeasurementTypeExcelViewById(), "onedata", Arrays.asList(UnitOfMeasurement));
	}

	@RequestMapping("pdfExp")
	public ModelAndView getAllUnitOfMeasurementTypeforPdf() {
		List<UnitOfMeasurement> list = service.getAllUnitOfMeasurementtype();
		return new ModelAndView(new UnitOfMeasurementTypePdfView(), "list", list);
	}

	@RequestMapping("pdfOne")
	public ModelAndView getUnitOfMeasurementTypeByIdforPdf(@RequestParam Integer uid) {
		UnitOfMeasurement UnitOfMeasurement = service.getUnitOfMeasurementtypeById(uid);
		return new ModelAndView(new UnitOfMeasurementTypePdfViewById(), "onedata", Arrays.asList(UnitOfMeasurement));
	}

	@RequestMapping("report")
	public String getUnitOfMeasurementTypeCount() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getUnitOfMeasurementtypeCount();
		utility.generatePieChart(path, list);
		utility.generateBarChart(path, list);
		return "UnitOfMeasurementtypeCountReport";
	}

}