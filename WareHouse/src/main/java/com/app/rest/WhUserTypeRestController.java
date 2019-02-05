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

import com.app.model.WhUserType;
import com.app.service.IWhuserTypeService;

@RestController
@RequestMapping("/rest/whusertype")
public class WhUserTypeRestController {

	
	@Autowired
	private IWhuserTypeService service;
	
	
	@RequestMapping(value = "/all")
	public ResponseEntity<?> getAllWhUserType() {

		List<WhUserType> list = service.getAllWhuserType();

		if (list != null && list.isEmpty() == false) {
			return new ResponseEntity<List<WhUserType>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	} 

	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<?> getOneUom(@PathVariable Integer id) {

		WhUserType wut = service.getWhusertypeById(id);

		if (wut != null) {
			return new ResponseEntity<WhUserType>(wut, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Available", HttpStatus.BAD_REQUEST);
		}
	} 

	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteWhUserType(@PathVariable Integer id) {

		try {
			service.deleteWhusertype(id);
			return new ResponseEntity<String>(id + " no. Record deleted..", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Record is not available..", HttpStatus.BAD_REQUEST);
		}

	} 
	
	@PostMapping(value = "/save")
	public ResponseEntity<?> saveWhUserType(@RequestBody WhUserType wut) {

		try {
			Integer id = service.saveWhusertype(wut);
			return new ResponseEntity<String>(id + " record is added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(" Record not available...", HttpStatus.BAD_REQUEST);
		}
	} 

	@PostMapping(value = "/update")
	public ResponseEntity<?> updateWhUserType(@RequestBody WhUserType wut) {
       
		try {
			service.updateWhusertype(wut);
			return new ResponseEntity<String>(wut.getWhid()+" no. Record is updated..",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(" Record not found...",HttpStatus.BAD_REQUEST);
		}
	}

}
