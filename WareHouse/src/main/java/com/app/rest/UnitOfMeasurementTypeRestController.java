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
import com.app.model.UnitOfMeasurement;
import com.app.service.IUnitOfMeasurementTypeService;

@RestController
@RequestMapping(value="/rest/UnitOfMeasurement")
public class UnitOfMeasurementTypeRestController {
	
	@Autowired
	private IUnitOfMeasurementTypeService service;
	
	@RequestMapping(value = "/all")
	public ResponseEntity<?> getAllUnitOfMeasurement() {

		List<UnitOfMeasurement> list = service.getAllUnitOfMeasurementtype();

		if (list != null && list.isEmpty() == false) {
			return new ResponseEntity<List<UnitOfMeasurement>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<?> getOneUnitOfMeasurement(@PathVariable Integer id) {

		UnitOfMeasurement UnitOfMeasurement = service.getUnitOfMeasurementtypeById(id);

		if (UnitOfMeasurement != null) {
			return new ResponseEntity<UnitOfMeasurement>(UnitOfMeasurement, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteUnitOfMeasurement(@PathVariable Integer id) {

		try {
			service.deleteUnitOfMeasurementById(id);
			return new ResponseEntity<String>(id + " no. Record deleted..", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Record is not available..", HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveUnitOfMeasurement(@RequestBody UnitOfMeasurement UnitOfMeasurement) {

		try {
			Integer id = service.saveUnitOfMeasurementtype(UnitOfMeasurement);
			return new ResponseEntity<String>(id + " record is added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(" Record not available...", HttpStatus.BAD_REQUEST);
		}
	}


	@PostMapping(value = "/update")
	public ResponseEntity<?> updateUnitOfMeasurement(@RequestBody UnitOfMeasurement UnitOfMeasurement) {
       
		try {
			service.updateUnitOfMeasurementtype(UnitOfMeasurement);
			return new ResponseEntity<String>(UnitOfMeasurement.getUomId()+" no. Record is updated..",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(" Record not found...",HttpStatus.BAD_REQUEST);
		}
	}

}
