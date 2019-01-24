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

import com.app.excelview.OrderMethodExcelView;
import com.app.excelview.OrderMethodExcelViewById;
import com.app.model.OrderMethod;
import com.app.pdfview.OrderMethodPdfView;
import com.app.pdfview.OrderMethodPdfViewById;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtility;

@Controller
@RequestMapping(value = "/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private OrderMethodUtility utility;

	@RequestMapping(value = "/register")
	public String regOrderMethod(ModelMap map) {
		map.addAttribute("OM", new OrderMethod());
		return "OrderMethodRegister";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String saveOrderMethod(@ModelAttribute OrderMethod om, ModelMap map) {

		System.out.println(" " + om.getDesc() + "  " + om.getExecutetype() + " " + om.getOrdercode() + "  "
				+ om.getOrdermode() + "  " + om.getOrderaccept() + " " + om.getOid());

		Integer id = service.saveOrderMethod(om);

		String msg = "record inserted no is " + id;

		// add attribute to map
		map.addAttribute("message", msg);

		// clean the object
		map.addAttribute("OM", new OrderMethod());

		return "OrderMethodRegister";
	}

	@RequestMapping(value = "all")
	public String getAllOrderMethod(ModelMap map) {
		List<OrderMethod> list = service.getAllOrderMethod();

		map.addAttribute("data", list);
		return "OrderMethodData";
	}
	

	@RequestMapping(value = "delete")
	public String deleteOrderMethod(@RequestParam("oid") Integer id, ModelMap map) {
		service.deleteOrderMethod(id);

		String msg = "deleted " + id + " number record";

		map.addAttribute("message", msg);

		// again get element back
		List<OrderMethod> list = service.getAllOrderMethod();

		// add data to map
		map.addAttribute("data", list);

		return "OrderMethodData";
	}

	@RequestMapping(value = "viewOne")
	public String getOrderMethodById(@RequestParam Integer oid, ModelMap map) {

		OrderMethod ordermeth = service.getOrderMethodById(oid);

		map.addAttribute("om", ordermeth);

		return "OrderMethodView";
	}

	@RequestMapping(value = "editOne")
	public String editOrderMethod(@RequestParam Integer oid, ModelMap map) {

		map.addAttribute("OM", service.getOrderMethodById(oid));

		return "OrderMethodEdit";
	}

	@RequestMapping(value = "update")
	public String updateOrderMethod(@ModelAttribute OrderMethod om, ModelMap map) {

		// call service
		service.updateOrderMethod(om);

		// add to map attribute
		map.addAttribute("message", "Record " + om.getOid() + " updated");

		// add many record to map
		map.addAttribute("data", service.getAllOrderMethod());

		return "OrderMethodData";
	}

	
	@RequestMapping("excelall")
	public ModelAndView getAllOrderMethodExcel() {
		List<OrderMethod> list = service.getAllOrderMethod();
		return new ModelAndView(new OrderMethodExcelView(), "list", list);
	}

	
	@RequestMapping("excelOne")
	public ModelAndView getOrderMethodById(@RequestParam Integer oid) {
		OrderMethod om = service.getOrderMethodById(oid);
		return new ModelAndView(new OrderMethodExcelViewById(), "onedata", Arrays.asList(om));
	}
	
	@RequestMapping("pdfExp")
	public ModelAndView getAllOrderMethodforPdf() {
		List<OrderMethod> list = service.getAllOrderMethod();
		return new ModelAndView(new OrderMethodPdfView(), "list", list);
	}

	@RequestMapping("pdfOne")
	public ModelAndView getOrderMethodPdfById(@RequestParam Integer oid) {
		OrderMethod om = service.getOrderMethodById(oid);
		return new ModelAndView(new OrderMethodPdfViewById(), "onedata", Arrays.asList(om));
	}

	@RequestMapping("report")
	public String getOrderMethodByCount() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getOrderModeByCount();
		utility.generatePieChart(path, list);
		return "OrderMethodCountReport";
	}

}