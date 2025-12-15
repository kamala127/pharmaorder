package com.pharma.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="shipment")
public class Shipment {
	
	@Id
	@Column(length=36)
	private String shipmentId;
    private String orderId;
    private ShipmentStatus status;
    private LocalDate shippedDate;
    private LocalDate deliveredDate;
    
    @PrePersist
    protected void onCreate() {
    	this.shipmentId = UUID.randomUUID().toString();
    	
    }

}
