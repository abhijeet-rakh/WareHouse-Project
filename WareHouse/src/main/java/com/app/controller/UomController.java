package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

import com.app.excelview.UnitOfMeasurementExcelView;
import com.app.excelview.UnitOfMeasurementExcelViewById;
import com.app.model.Uom;
import com.app.pdfview.UnitOfMeasurementPdfView;
import com.app.pdfview.UnitOfMeasurementPdfViewById;
import com.app.service.IUomService;
import com.app.util.UomTypeUtility;
import com.app.validator.UomValidator;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@Autowired
	private UomValidator validator;

    @Autowired
	private ServletContext context;
	
    @Autowired
    private UomTypeUtility utility;
    
	
	// 1.show Register page
	@RequestMapping("/register")
	public String regUom(ModelMap map) {
		// create model class object and Add to ModelMap
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}

	// 2.Insert data in database
	@RequestMapping(value = "/insert", method = POST)
	public String saveUom(@ModelAttribute Uom uom, Errors errors, ModelMap map) {

		validator.validate(uom, errors);
		// if error exit
		if (errors.hasErrors()) {
			map.addAttribute("message", "Please Check all Errors");
		}
		// no Error Exit
		else {
			Integer id = service.saveUom(uom);
			String msg = "Saved with Id:" + id;
			map.addAttribute("message", msg);
			// clean Form Backing Object

			map.addAttribute("uom", new Uom());
		}
		return "UomRegister";
	}

	// 3.View all Records from DB
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		List<Uom> obs = service.getAllUom();
		map.addAttribute("list", obs);
		return "UomData";
	}

	// 4.delete row by id
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam Integer id, ModelMap map) {
		// delete row
		service.deleteUom(id);
		// read new data
		List<Uom> obs = service.getAllUom();
		map.addAttribute("list", obs);// key(list) and value(obs)
		// Convert obj data in String
		map.addAttribute("message", "Record " + id + "deleted success:");
		return "UomData";
	}

	// 5 view one Row Object
	@RequestMapping("/viewone")
	public String getOne(@RequestParam Integer id, ModelMap map) {
		Uom ob = service.getUombyId(id);
		map.addAttribute("st", ob);

		return "UomView";
	}

	// 6.Show edit page with a data
	@RequestMapping("/editone")
	public String showEdit(@RequestParam Integer id, ModelMap map) {
		// Call service method
		Uom uom = service.getUombyId(id);
		// Load Database Row as Object
		map.addAttribute("uom", uom);
		return "UomEdit";

	}

	// 7.Do update data
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Uom uom, ModelMap map) {
		// Call service update
		service.updateUom(uom);
		// Success Message
		map.addAttribute("message", "Uom Updated");
		// get new data
		map.addAttribute("list", service.getAllUom());
		return "UomData";
	}

	// 8.get all UOM
	@RequestMapping("/getAll")
	public String getAllUom() {
		service.getAllUom();
		return "UomData";
	}

	// 8. Export Data to Excel
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/excelOne")
	public ModelAndView getOneExcel(@RequestParam Integer id) {
		Uom list = service.getUombyId(id);
		return new ModelAndView(new UnitOfMeasurementExcelViewById(), "oneData", Arrays.asList(list));
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/pdfOne")
	public ModelAndView getOnePdf(@RequestParam Integer id) {
		Uom oneData = service.getUombyId(id);
		return new ModelAndView(new UnitOfMeasurementPdfViewById(), "oneData", Arrays.asList(oneData));
	}

	@RequestMapping(value = "/excelall")
	public ModelAndView getAllExcel() {
		List<Uom> list = service.getAllUom();
		return new ModelAndView(new UnitOfMeasurementExcelView(), "listdata", list);
	}

	@RequestMapping(value = "/pdfExp")
	public ModelAndView getAllPdf() {
		List<Uom> list = service.getAllUom();
        return new ModelAndView(new UnitOfMeasurementPdfView(),"data",list);
	}
	
	@RequestMapping(value="/report")
	public String getUomTypeCount() {
      String path=context.getRealPath("/");
      List<Object[]> list = service.getUomTypeCount();
      utility.generateBarChart(path, list);
      utility.generatePieChart(path, list);
      return "UomReport";        
	}

}
