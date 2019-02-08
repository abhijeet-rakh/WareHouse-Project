package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.excelview.PurchaseOrderExcelView;
import com.app.excelview.PurchaseOrderExcelViewById;
import com.app.model.PurchaseOrder;
import com.app.pdfview.PurchaseOrderPdfView;
import com.app.pdfview.PurchaseOrderPdfViewById;
import com.app.service.IPurchaseOrderService;
import com.app.validator.PurchaseOrderValidator;

@Controller
@RequestMapping(value="/purchaseorder")
public class PurchaseOrderController {


//	@Autowired
//	private PurchaseOrderValidator validator;

	@Autowired
	private IPurchaseOrderService service;

//	@Autowired
//	private ServletContext context;

//	@Autowired
//	private PurchaseOrderUtility utility;

	@RequestMapping(value = "/register")
	public String regPurchaseOrder(ModelMap map) {
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		return "PurchaseOrderRegister";
	}

	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, Errors errors, ModelMap map) {

	//	validator.validate(purchaseOrder, errors);
		if (errors.hasErrors()) {
			//if Error Exists
			map.addAttribute("message", "Please Check all Errors......");
		} else {			
			//if Error is not there
			Integer id = service.savePurchaseOrder(purchaseOrder);

			String msg = "record inserted no is " + id;

			// add attribute to map
			map.addAttribute("message", msg);

			// clean the object
			map.addAttribute("purchaseOrder", new PurchaseOrder());
		}
		return "PurchaseOrderRegister";
	}

	
	
	@RequestMapping(value = "/all")
	public String getAllPurchaseOrder(ModelMap map) {
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		map.addAttribute("data", list);
		return "PurchaseOrderData";
	}

	
	@RequestMapping(value = "/delete")
	public String deletePurchaseOrder(@RequestParam("orderId") Integer id, ModelMap map) {
		service.deletePurchaseOrder(id);

		String msg = "deleted " + id + " number record";

		map.addAttribute("message", msg);

		// again get element back
		List<PurchaseOrder> list = service.getAllPurchaseOrder();

		// add data to map
		map.addAttribute("data", list);

		return "PurchaseOrderData";
	}

	
	@RequestMapping(value = "/viewOne")
	public String getPurchaseOrderById(@RequestParam Integer orderId, ModelMap map) {

		PurchaseOrder Purord = service.getPurchaseOrderById(orderId);

		map.addAttribute("po", Purord);

		return "PurchaseOrderView";
	}

	
	@RequestMapping(value = "/editOne")
	public String editPurchaseOrder(@RequestParam Integer orderId, ModelMap map) {

		map.addAttribute("purchaseOrder", service.getPurchaseOrderById(orderId));

		return "PurchaseOrderEdit";
	}

	

	@RequestMapping(value = "/update")
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, ModelMap map) {

		// call service
		service.updatePurchaseOrder(purchaseOrder);

		// add to map attribute
		map.addAttribute("message", "Record " + purchaseOrder.getOrderId() + " updated");

		// add many record to map
		map.addAttribute("data", service.getAllPurchaseOrder());

		return "PurchaseOrderData";
	}

	
	@RequestMapping("/excelall")
	public ModelAndView getAllPurchaseOrderExcel() {
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		return new ModelAndView(new PurchaseOrderExcelView(), "list", list);
	}
	
	@RequestMapping("/excelOne")
	public ModelAndView getPurchaseOrderById(@RequestParam Integer orderId) {
		PurchaseOrder PurchaseOrder = service.getPurchaseOrderById(orderId);
		return new ModelAndView(new PurchaseOrderExcelViewById(), "onedata", Arrays.asList(PurchaseOrder));
	}
	

	@RequestMapping("/pdfExp")
	public ModelAndView getAllPurchaseOrderforPdf() {
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		return new ModelAndView(new PurchaseOrderPdfView(), "list", list);
	}

	@RequestMapping("/pdfOne")
	public ModelAndView getPurchaseOrderPdfById(@RequestParam Integer orderId) {
		PurchaseOrder PurchaseOrder = service.getPurchaseOrderById(orderId);
		return new ModelAndView(new PurchaseOrderPdfViewById(), "onedata", Arrays.asList(PurchaseOrder));
	}
/*
	@RequestMapping("report")
	public String getPurchaseOrderByCount() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getOrderModeByCount();
		utility.generatePieChart(path, list);
		utility.generateBarChart(path, list);
		return "PurchaseOrderCountReport";
	}
*/

	
	
	
}
