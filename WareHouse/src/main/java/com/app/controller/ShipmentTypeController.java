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

import com.app.excelview.ShipmentTypeExcelView;
import com.app.excelview.ShipmentTypeExcelViewById;
import com.app.model.ShipmentType;
import com.app.pdfview.ShipmentTypePdfView;
import com.app.pdfview.ShipmentTypePdfViewById;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtility;
import com.app.validator.ShipmentTypeValidator;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {

	@Autowired
	private ShipmentTypeValidator validator;

	@Autowired
	private IShipmentTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private ShipmentTypeUtility utility;

	@RequestMapping(value = "/register")
	public String showRegister(ModelMap map) {
		// add ShipmentType object to map attribute
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String addShipmentType(@ModelAttribute ShipmentType shipmentType, Errors errors, ModelMap map) {

		validator.validate(shipmentType, errors);

		if (errors.hasErrors()) {
			//If Error is there
             map.addAttribute("message","Please Check Error........");
		} else {
			//If Error is not there
			Integer id = service.saveShipmentType(shipmentType);

			String message = "Your registration No is=" + id;

			map.addAttribute("message", message);

			// clean the object and send new Object to Spring form
			map.addAttribute("shipmentType", new ShipmentType());
		}

		return "ShipmentTypeRegister";
	}

	@RequestMapping(value = "/all")
	public String getAllShipmentType(ModelMap map) {
		List<ShipmentType> list = service.getAllShipmentType();
		map.addAttribute("data", list);
		return "ShipmentTypeData";
	}

	@RequestMapping(value = "delete")
	public String deleteShipmentType(@RequestParam("sid") Integer id, ModelMap map) {
		service.deleteShipmentType(id);

		String msg = "deleted " + id + " number record";

		// add msg to map
		map.addAttribute("message", msg);

		// get record form database
		List<ShipmentType> list = service.getAllShipmentType();

		// add to map
		map.addAttribute("data", list);
		return "ShipmentTypeData";
	}

	@RequestMapping("viewOne")
	public String viewShipmentType(@RequestParam Integer sid, ModelMap map) {
		ShipmentType shiptype = service.getShipmentTypeById(sid);

		map.addAttribute("st", shiptype);

		return "ShipmentTypeView";
	}

	@RequestMapping(value = "editOne")
	public String editShipmentType(@RequestParam Integer sid, ModelMap map) {

		ShipmentType st = service.getShipmentTypeById(sid);

		map.addAttribute("shipmentType", st);

		return "ShipmentTypeEdit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType, ModelMap map) {

		// update record
		service.updateShipmentType(shipmentType);

		map.addAttribute("message", "updated " + shipmentType.getId() + " Record");

		map.addAttribute("data", service.getAllShipmentType());

		return "ShipmentTypeData";
	}

	@RequestMapping(value = "excelExp")
	public ModelAndView getAllShipmentinExcel() {
		List<ShipmentType> list = service.getAllShipmentType();
		return new ModelAndView(new ShipmentTypeExcelView(), "excellist", list);
	}

	@RequestMapping("excelOne")
	public ModelAndView getShipmentExcelById(@RequestParam Integer sid) {
		ShipmentType shipment = service.getShipmentTypeById(sid);
		return new ModelAndView(new ShipmentTypeExcelViewById(), "excel", Arrays.asList(shipment));
	}

	@RequestMapping("pdfExp")
	public ModelAndView getAllShipmentTypePdf() {
		List<ShipmentType> list = service.getAllShipmentType();
		return new ModelAndView(new ShipmentTypePdfView(), "list", list);
	}

	@RequestMapping("pdfOne")
	public ModelAndView getShipmentTypePdfById(@RequestParam Integer sid) {
		ShipmentType shipment = service.getShipmentTypeById(sid);
		return new ModelAndView(new ShipmentTypePdfViewById(), "onedata", Arrays.asList(shipment));
	}

	@RequestMapping("report")
	public String getShipmentTypeCount() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getShipmentTypeCount();
		utility.generatePieChart(path, list);
		utility.generateBarChart(path, list);
		return "ShipmentTypeCountReport";
	}

}