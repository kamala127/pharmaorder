package com.pharma.entity;

import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@Column(length=36)
	private String inventoryId;
	
	@NotNull(message = "Drug Id should not be blank")
    private String drugId;
	
	@NotNull(message = "Batch Id should not be blank")
    private String batchId;
	
	@NotNull(message = "Available Quantity should not be blank")
    private int availableQuantity;
	
	@NotNull(message = "Warehouse Location should not be blank")
    private String warehouseLocation;
    
    @PrePersist
    protected void onCreate() {
    	this.inventoryId = UUID.randomUUID().toString();
    	
    }

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
    
    

}
