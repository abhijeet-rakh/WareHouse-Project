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

import com.app.excelview.SaleOrderExcelView;
import com.app.excelview.SaleOrderExcelViewById;
import com.app.model.SaleOrder;
import com.app.pdfview.SaleOrderPdfView;
import com.app.pdfview.SaleOrderPdfViewById;
import com.app.service.ISaleOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.util.SaleOrderUtility;
import com.app.validator.SaleOrderValidator;

@Controller
@RequestMapping(value="/saleorder")
public class SaleOrderController {

//	@Autowired
//	private SaleOrderValidator validator;

	@Autowired
	private ISaleOrderService service;
	
	@Autowired
	private IShipmentTypeService shipservice;
	
	@Autowired
	private IWhUserTypeService whservice;
	
	
	@Autowired
	private ServletContext context;

	@Autowired
	private SaleOrderUtility utility;

	@RequestMapping(value = "/register")
	public String regSaleOrder(ModelMap map) {
		
		map.addAttribute("saleOrder", new SaleOrder());
		
		//Add Shipment Modes to sale order
		map.addAttribute("shipmenttype", shipservice.getEnableShipmentMode());
		
		//Add WareHouseUser Type to sale order
		map.addAttribute("whservice", whservice.getVendors());
				
		return "SaleOrderRegister";
	}

	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String saveSaleOrder(@ModelAttribute SaleOrder saleOrder, Errors errors, ModelMap map) {

	//	validator.validate(saleOrder, errors);

		if (errors.hasErrors()) {
			//if Error Exists
			map.addAttribute("message", "Please Check all Errors......");
		} else {			
			//if Error is not there
			Integer id = service.saveSaleOrder(saleOrder);

			String msg = "record inserted no is " + id;

			// add attribute to map
			map.addAttribute("message", msg);
		
			//Add Shipment Modes to sale order
			map.addAttribute("shipmenttype", shipservice.getEnableShipmentMode());
		
			//Add WareHouseUser Type to sale order
			map.addAttribute("whservice", whservice.getVendors());
			
			// clean the object
			map.addAttribute("saleOrder", new SaleOrder());
		}
	
		return "SaleOrderRegister";
	}

	
	@RequestMapping(value = "/all")
	public String getAllSaleOrder(ModelMap map) {
		List<SaleOrder> list = service.getAllSaleOrder();
        map.addAttribute("data", list);
        return "SaleOrderData";
	}

	
	 
	@RequestMapping(value = "/delete")
	public String deleteSaleOrder(@RequestParam("orderId") Integer id, ModelMap map) {
		service.deleteSaleOrder(id);

		String msg = "deleted " + id + " number record";

		map.addAttribute("message", msg);

		// again get element back
		List<SaleOrder> list = service.getAllSaleOrder();

		// add data to map
		map.addAttribute("data", list);

		return "SaleOrderData";
	}

	
	@RequestMapping(value = "/viewOne")
	public String getSaleOrderById(@RequestParam Integer orderId, ModelMap map) {

		SaleOrder suord = service.getSaleOrderById(orderId);

		map.addAttribute("saleOrder", suord);

		return "SaleOrderView";
	}

	
	@RequestMapping(value = "/editOne")
	public String editSaleOrder(@RequestParam Integer orderId, ModelMap map) {
		map.addAttribute("saleOrder", service.getSaleOrderById(orderId));
		
		//Add Shipment Modes to sale order
		map.addAttribute("shipmenttype", shipservice.getEnableShipmentMode());
		
		//Add WareHouseUser Type to sale order
		map.addAttribute("whservice", whservice.getVendors());
		
		return "SaleOrderEdit";
	}

	

	@RequestMapping(value = "/update")
	public String updateSaleOrder(@ModelAttribute SaleOrder saleOrder, ModelMap map) {

		// call service
		service.updateSaleOrder(saleOrder);

		// add to map attribute
		map.addAttribute("message", "Record " + saleOrder.getOrderId() + " updated");

		//Add Shipment Modes to sale order
		map.addAttribute("shipmenttype", shipservice.getEnableShipmentMode());
		
		//Add WareHouseUser Type to sale order
		map.addAttribute("whservice", whservice.getVendors());
		
		// add many record to map
		map.addAttribute("data", service.getAllSaleOrder());

		return "SaleOrderData";
	}

	
	
	@RequestMapping("/excelall")
	public ModelAndView getAllSaleOrderExcel() {
		List<SaleOrder> list = service.getAllSaleOrder();
		return new ModelAndView(new SaleOrderExcelView(), "list", list);
	}
	
	
	
	@RequestMapping("/excelOne")
	public ModelAndView getSaleOrderById(@RequestParam Integer orderId) {
		SaleOrder SaleOrder = service.getSaleOrderById(orderId);
		return new ModelAndView(new SaleOrderExcelViewById(), "onedata", Arrays.asList(SaleOrder));
	}
	
	
	@RequestMapping("/pdfExp")
	public ModelAndView getAllSaleOrderforPdf() {
		List<SaleOrder> list = service.getAllSaleOrder();
		return new ModelAndView(new SaleOrderPdfView(), "list", list);
	}

	@RequestMapping("/pdfOne")
	public ModelAndView getSaleOrderPdfById(@RequestParam Integer orderId) {
		SaleOrder SaleOrder = service.getSaleOrderById(orderId);
		return new ModelAndView(new SaleOrderPdfViewById(), "onedata", Arrays.asList(SaleOrder));
	}
	

	@RequestMapping("/report")
	public String getSaleOrderByCount() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getSaleOrderByCount();
		utility.generatePieChart(path, list);
		utility.generateBarChart(path, list);
		return "SaleOrderReport";
	}


         
	
}
