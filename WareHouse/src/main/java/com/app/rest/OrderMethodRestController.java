package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping(value = "/rest/order")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;

	@RequestMapping(value = "/all")
	public ResponseEntity<?> getAllOtrders() {

		List<OrderMethod> list = service.getAllOrderMethod();

		if (list != null && list.isEmpty() == false) {
			return new ResponseEntity<List<OrderMethod>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	}// getAllOtrders()

	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<?> getOneOrder(@PathVariable Integer id) {

		OrderMethod om = service.getOrderMethodById(id);

		if (om != null) {
			return new ResponseEntity<OrderMethod>(om, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	}// getOneOrder

	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {

		try {
			service.deleteOrderMethod(id);
			return new ResponseEntity<String>(id + " no. Record deleted..", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Record is not available..", HttpStatus.BAD_REQUEST);
		}

	}// deleteOrder

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveOrder(@RequestBody OrderMethod om) {

		try {
			Integer id = service.saveOrderMethod(om);
			return new ResponseEntity<String>(id + " record is added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(" Record not available...", HttpStatus.BAD_REQUEST);
		}
	}// saveOrder


	@PostMapping(value = "/update")
	public ResponseEntity<?> updateOrder(@RequestBody OrderMethod om) {
       
		try {
			service.updateOrderMethod(om);
			return new ResponseEntity<String>(om.getOid()+" no. Record is updated..",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(" Record not found...",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
