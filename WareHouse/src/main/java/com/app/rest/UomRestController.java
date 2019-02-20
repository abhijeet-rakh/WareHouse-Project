package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.service.IUomService;

@SuppressWarnings("static-access")
@RestController
@RequestMapping("/rest/uom")
public class UomRestController {
	

	@Autowired
	private IUomService service;

//1.GET ALL RECORD
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> response = null;
		List<Uom> uoms = service.getAllUom();
		if (uoms != null && !uoms.isEmpty()) {
			response = new ResponseEntity<List<Uom>>(HttpStatus.OK).ok(uoms);

		} else 
		{
			response = new ResponseEntity<String>("No Data Available", HttpStatus.OK);
		}
		return response;
	}

//2.GET ONE RECORD on id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		ResponseEntity<?> response = null;
		Uom uom = service.getUombyId(id);
		if (uom != null) {

			response = new ResponseEntity<Uom>(uom, HttpStatus.OK);

		} else {
			response = new ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

//3.DELETE ONE RECORD
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Integer id) {
		ResponseEntity<?> response = null;
		try {
			service.deleteUom(id);
			response = new ResponseEntity<String>("UOM" + id + "Deleted", HttpStatus.OK);

		} catch (Exception e) {

			response = new ResponseEntity<String>("UOM" + id + "NOT Found", HttpStatus.BAD_REQUEST);

		}

		return response;
	}

	// 4.SAVE DATA IN DB AS ONE ROW
	@PostMapping("/save")
	public ResponseEntity<?> saveData(@RequestBody Uom u) {

		int uid = service.saveUom(u);
		String body = "UOM'" + uid + "'Saved";

		return new ResponseEntity<String>(body, HttpStatus.OK);
	}

	// 5.Update DATA IN DB AS ONE ROW
	@PutMapping("/update")
	public ResponseEntity<?> updateData(@RequestBody Uom u) {
		ResponseEntity<String> re = null;
		try {
			service.updateUom(u);
			re = new ResponseEntity<String>("Update Success", HttpStatus.BAD_REQUEST);

			return new ResponseEntity<String>("Update Successfully", HttpStatus.OK);
		} catch (Exception e) {
		return	re = new ResponseEntity<String>("Uom'" + u.getUomId() + "'NotFound", HttpStatus.BAD_REQUEST);
		}
	}
	
}
