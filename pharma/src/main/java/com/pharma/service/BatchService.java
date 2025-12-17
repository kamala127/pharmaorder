package com.pharma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.dao.BatchRepository;
import com.pharma.entity.Batch;

@Service
public class BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	
	
	
	
	// Create a Batch
	
	public String createBatch(Batch batch) {
		
		batchRepository.save(batch);
		
		return "Batch Created !";
		
	}
	
	// Get All Batch
	
	public List<Batch> getAll(){
		List<Batch> response = batchRepository.findAll();
		return response;
				
	}

}
