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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping(value="/rest/shipment")
public class ShipmentTypeRestController {
	
	@Autowired
	private IShipmentTypeService service;
		
	@RequestMapping(value = "/all")
	public ResponseEntity<?> getAllShipments() {

		List<ShipmentType> list = service.getAllShipmentType();

		if (list != null && list.isEmpty() == false) {
			return new ResponseEntity<List<ShipmentType>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<?> getOneShipment(@PathVariable Integer id) {

		ShipmentType om = service.getShipmentTypeById(id);

		if (om != null) {
			return new ResponseEntity<ShipmentType>(om, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteShipment(@PathVariable Integer id) {

		try {
			service.deleteShipmentType(id);
			return new ResponseEntity<String>(id + " no. Record deleted..", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Record is not available..", HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveShipment(@RequestBody ShipmentType st) {

		
		try {
			Integer id = service.saveShipmentType(st);
			return new ResponseEntity<String>(id + " record is added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(" Record not available...", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/update")
	public ResponseEntity<?> updateShipment(@RequestBody ShipmentType st) {
       
		try {
			service.updateShipmentType(st);
			return new ResponseEntity<String>(st.getId()+" no. Record is updated..",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(" Record not found...",HttpStatus.BAD_REQUEST);
		}
	}

}
