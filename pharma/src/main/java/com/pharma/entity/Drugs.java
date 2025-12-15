package com.pharma.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="drugs")
public class Drugs {
	
	@Id
	@Column(length = 36)
	private String durgId;
	
	@Column(name="durg_name",nullable = false)
	private String drugName;
	
	@Column(name="manufacturer", nullable = false)
	private String manufacturer;
	
	@Column(name="drug_desc", nullable = false)
	private String drugDesc;
	@Column(name="drug_price", nullable = false)
	private double drugPrice;
	
	@Column(name="drug_manufactor_date", nullable = false)
	private LocalDate drugmanufactorDate;
	@Column(name="drug_expire_date", nullable = false)
	private LocalDate drugexpireDate;
	
	@PrePersist
    protected void onCreate() {
    	this.durgId = UUID.randomUUID().toString();
        
    }

	public String getDurgId() {
		return durgId;
	}

	public void setDurgId(String durgId) {
		this.durgId = durgId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugDesc() {
		return drugDesc;
	}

	public void setDrugDesc(String drugDesc) {
		this.drugDesc = drugDesc;
	}

	public double getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(double drugPrice) {
		this.drugPrice = drugPrice;
	}

	public LocalDate getDrugmanufactorDate() {
		return drugmanufactorDate;
	}

	public void setDrugmanufactorDate(LocalDate drugmanufactorDate) {
		this.drugmanufactorDate = drugmanufactorDate;
	}

	public LocalDate getDrugexpireDate() {
		return drugexpireDate;
	}

	public void setDrugexpireDate(LocalDate drugexpireDate) {
		this.drugexpireDate = drugexpireDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	
	
	
}
