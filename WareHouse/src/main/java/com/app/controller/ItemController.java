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

import com.app.excelview.ItemExcelView;
import com.app.excelview.ItemExcelViewById;
import com.app.model.Item;
import com.app.model.UOM;
import com.app.pdfview.ItemPdfView;
import com.app.pdfview.ItemPdfViewById;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUOMTypeService;
import com.app.util.ItemUtility;
import com.app.validator.ItemValidator;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemValidator validator;

	@Autowired
	private IItemService service;
	
	@Autowired
	private IOrderMethodService ordservice;
	
	@Autowired
	private IUOMTypeService uomservice;
	

//	@Autowired
//	private ServletContext context;

//	@Autowired
//	private ItemUtility utility

	@RequestMapping(value = "/register")
	public String regItem(ModelMap map) {
		map.addAttribute("item",new Item());

		//Show uom model in registration page(Module Integration) 
		map.addAttribute("uoms",uomservice.getAllUOMtype());
		
		//show OrderMethod model in registration page(Module Integration)
		map.addAttribute("ordermethods",ordservice.getAllOrderMethod());
		
		return "ItemRegister";
	}

	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String saveItem(@ModelAttribute Item item, Errors errors, ModelMap map) {

		validator.validate(item, errors);
		if (errors.hasErrors()) {
			//if Error Exists
			map.addAttribute("message", "Please Check all Errors......");
		} else {			
			//if Error is not there
			Integer id = service.saveItem(item);

			String msg = "record inserted no is " + id;

			// add attribute to map
			map.addAttribute("message", msg);

			//Show uom model in registration page(Module Integration) 
			map.addAttribute("uoms",uomservice.getAllUOMtype());
		
			
			//show OrderMethod model in registration page(Module Integration)
			map.addAttribute("ordermethods",ordservice.getAllOrderMethod());
			
			
			// clean the object
			map.addAttribute("item", new Item());
			
		}
		return "ItemRegister";
	}

	
	
	@RequestMapping(value = "/all")
	public String getAllItem(ModelMap map) {
		List<Item> list = service.getAllItem();

		map.addAttribute("data", list);
		return "ItemData";
	}


	@RequestMapping(value = "/delete")
	public String deleteItem(@RequestParam("itemId") Integer id, ModelMap map) {
		service.deleteItem(id);

		String msg = "deleted " + id + " number record";

		map.addAttribute("message", msg);

		// again get element back
		List<Item> list = service.getAllItem();

		// add data to map
		map.addAttribute("data", list);

		return "ItemData";
	}


	@RequestMapping(value = "/viewOne")
	public String getItemById(@RequestParam Integer itemId, ModelMap map) {

		Item itemmeth = service.getItemById(itemId);

		map.addAttribute("item", itemmeth);

		return "ItemView";
	}

	
	@RequestMapping(value = "/editOne")
	public String editItem(@RequestParam Integer itemId, ModelMap map) {

		map.addAttribute("item", service.getItemById(itemId));

		//Show uom model in registration page(Module Integration) 
		map.addAttribute("uoms",uomservice.getAllUOMtype());

		//show OrderMethod model in registration page(Module Integration)
		map.addAttribute("ordermethods",ordservice.getAllOrderMethod());
		
		
		return "ItemEdit";
	}

	

	@RequestMapping(value = "/update")
	public String updateItem(@ModelAttribute Item item, ModelMap map) {

		// call service
		service.updateItem(item);

		// add to map attribute
		map.addAttribute("message", "Record " + item.getItemId() + " updated");

		// add many record to map
		map.addAttribute("data", service.getAllItem());

		return "ItemData";
	}

	
	@RequestMapping("/excelall")
	public ModelAndView getAllItemExcel() {
		List<Item> list = service.getAllItem();
		return new ModelAndView(new ItemExcelView(), "list", list);
	}

	@RequestMapping("/excelOne")
	public ModelAndView getItemById(@RequestParam Integer itemId) {
		Item item = service.getItemById(itemId);
		return new ModelAndView(new ItemExcelViewById(), "onedata", Arrays.asList(item));
	}
	

	@RequestMapping("/pdfExp")
	public ModelAndView getAllItemforPdf() {
		List<Item> list = service.getAllItem();
		return new ModelAndView(new ItemPdfView(), "list", list);
	}

	@RequestMapping("/pdfOne")
	public ModelAndView getItemPdfById(@RequestParam Integer itemId) {
		Item item = service.getItemById(itemId);
		return new ModelAndView(new ItemPdfViewById(), "onedata", Arrays.asList(item));
	}
	

/*
	@RequestMapping("report")
	public String getItemByCount() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getOrderModeByCount();
		utility.generatePieChart(path, list);
		utility.generateBarChart(path, list);
		return "ItemCountReport";
	}
*/
		
}
