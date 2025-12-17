package com.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.entity.Batch;
import com.pharma.service.BatchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	
	
	@Autowired
	private BatchService batchService;
	
	
	// Create Batch
	@PostMapping("/create")
	public ResponseEntity<String> createBatch(@RequestBody @Valid Batch batch){
		
		String response = batchService.createBatch(batch);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
		
	}
	
	
	// Get All Batch
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllBatch(){
	List<Batch> response =	batchService.getAll();
	
	return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	
	
	}

}
