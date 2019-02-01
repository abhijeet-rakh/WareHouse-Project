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
import com.app.model.UOM;
import com.app.service.IUOMTypeService;

@RestController
@RequestMapping(value="/rest/uom")
public class UOMTypeRestController {
	
	@Autowired
	private IUOMTypeService service;
	
	@RequestMapping(value = "/all")
	public ResponseEntity<?> getAllUom() {

		List<UOM> list = service.getAllUOMtype();

		if (list != null && list.isEmpty() == false) {
			return new ResponseEntity<List<UOM>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<?> getOneUom(@PathVariable Integer id) {

		UOM uom = service.getUOMtypeById(id);

		if (uom != null) {
			return new ResponseEntity<UOM>(uom, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteUom(@PathVariable Integer id) {

		try {
			service.deleteUOMById(id);
			return new ResponseEntity<String>(id + " no. Record deleted..", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Record is not available..", HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveUom(@RequestBody UOM uom) {

		try {
			Integer id = service.saveUOMtype(uom);
			return new ResponseEntity<String>(id + " record is added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(" Record not available...", HttpStatus.BAD_REQUEST);
		}
	}


	@PostMapping(value = "/update")
	public ResponseEntity<?> updateUom(@RequestBody UOM uom) {
       
		try {
			service.updateUOMtype(uom);
			return new ResponseEntity<String>(uom.getUomid()+" no. Record is updated..",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(" Record not found...",HttpStatus.BAD_REQUEST);
		}
	}

}
