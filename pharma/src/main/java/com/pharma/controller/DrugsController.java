package com.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.entity.Drugs;
import com.pharma.service.DrugsService;

@RestController
@RequestMapping("/drugs")
public class DrugsController {
	
	@Autowired
	private DrugsService drugService;
	
	
	// Create Drugs
	@PostMapping("/createdrug")
	public ResponseEntity<String> createDrug(@RequestBody Drugs drugs ){
		
	String response	= drugService.drugCreate(drugs);
	
			if(response.contains("Created")) {
				return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(response);
			}
				
			
			return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(response);
		
	}
	
	
	// Get All Drugs
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		List<Drugs> drugs =  drugService.getAll();
		
		if(drugs.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No Drugs are Available! ");
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(drugs);
	}

}
