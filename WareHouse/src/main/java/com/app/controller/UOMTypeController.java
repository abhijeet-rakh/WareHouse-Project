package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelview.UOMTypeExcelView;
import com.app.excelview.UOMTypeExcelViewById;
import com.app.model.UOM;
import com.app.service.IUOMTypeService;

@Controller
@RequestMapping(value = "/uomtype")
public class UOMTypeController {

	@Autowired
	private IUOMTypeService service;

	@RequestMapping(value = "/register")
	public String regUOMType(ModelMap map) {

		// add new Object to map
		map.addAttribute("UM", new UOM());

		return "UOMTypeRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveUOMType(@ModelAttribute UOM uom, ModelMap map) {

		String msg = null;

		Integer id = service.saveUOMtype(uom);

		msg = "record " + id + " inserted";

		map.addAttribute("message", msg);

		// clean previous object and add new to spring form tag map
		map.addAttribute("UM", new UOM());

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
	public ModelAndView getAllUOMType() {
		List<UOM> list = service.getAllUOMtype();

		return new ModelAndView(new UOMTypeExcelView(), "list", list);
	}

	@RequestMapping("excelOne")
	public ModelAndView getUOMTypeById(@RequestParam Integer uid) {
		UOM uom = service.getUOMtypeById(uid);

		return new ModelAndView(new UOMTypeExcelViewById(),"onedata", Arrays.asList(uom));
	}

	
}
