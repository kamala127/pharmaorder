package com.pharma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	// Get Drug By Id
	@GetMapping("/getDrug/{id}")
	public ResponseEntity<?> getDrugbyId(@PathVariable("id") String id ){
		
		Optional<Drugs> response = drugService.getDrugById(id);
		
		if (response.isPresent()) {
	        return ResponseEntity
	                .status(HttpStatus.OK)
	                .body(response.get());
	    } else {
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body("Drug not found with id: " + id);
	    }
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
	
	
	// Delete Drugs by Id
	@DeleteMapping("/deletedrug/{id}")
	public ResponseEntity<String> deleteDrugsbyId(@PathVariable("id")String id){
		
		boolean response = drugService.deletedrugbyId(id);
		
		if(response==true) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Durg is deleted !");
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Durgs is not found by ID: "+id);
		
	}
	
	
	// Update Drug Price
	@PutMapping("/updatePrice/{id}")
	public ResponseEntity<String> updateDrugPrice(@PathVariable("id")String id,
			@RequestParam("updatedprice") double updatedPrice){
		
		boolean response = drugService.updateDrugprice(id, updatedPrice);
		
		if(response==true) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Durg Price Updated !");
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Durgs is not found by ID: "+id);
	}
	
	
	

}
