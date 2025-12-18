package com.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.entity.Inventory;
import com.pharma.service.InventoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	
	// Create Inventory
	@PostMapping("/create")
	public ResponseEntity<String> createInventory(@RequestBody @Valid Inventory inventory){
		
		
		String response  = inventoryService.createInventory(inventory);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	
	
	
	// Get All Inventory
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllInventory(){
		List<Inventory> response = inventoryService.getAll();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	
	
	// Delete All Inventory
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll(){
		String response = inventoryService.deleteAll();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	

}
