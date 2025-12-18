package com.pharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.dao.InventoryRepository;
import com.pharma.entity.Inventory;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	
	
	// Create Inventory
	
	public String createInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
		return "inventory Created!";
	}
	
	
	// Get All Inventory
	
	public List<Inventory> getAll(){
		return inventoryRepository.findAll();
	}
	
	// Delete All Inventory
	public String deleteAll() {
		inventoryRepository.deleteAll();
		return "All Inventory Deleted";
	}

}
