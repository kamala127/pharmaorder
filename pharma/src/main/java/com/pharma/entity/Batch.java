package com.pharma.entity;

import java.time.LocalDate;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="batch")
public class Batch {
	
	@Id
	@Column(length = 36)
	private String batchId;
	@NotNull(message = "Drug Id Can't be Null")
    private String drugId;
	@NotNull(message = "Manufacture Date Can't be Null")
    private LocalDate manufactureDate;
	@NotNull(message = "Expire Date Can't be Null")
    private LocalDate expiryDate;
    
    @PrePersist
    protected void onCreate() {
    	this.batchId = UUID.randomUUID().toString();
    	
    }

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
    
    

}
