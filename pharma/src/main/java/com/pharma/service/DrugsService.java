package com.pharma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pharma.dao.DrugRepository;
import com.pharma.entity.Drugs;

@Service
public class DrugsService {
	
	@Autowired
	private DrugRepository drugsRepository;
	
	
	
	//List Drug
	
	public String drugCreate(Drugs drug) {
		drugsRepository.save(drug);
		return "Drug Created!";
	}
	
	// Get All Drugs
	
	public List<Drugs> getAll(){
		return drugsRepository.findAll();
	}
	
	
	// Get Drug by ID
	public Optional<Drugs> getDrugById(String id) {
	    return drugsRepository.findById(id);
	}
	
	// Delete Drugs by ID
	
	public boolean deletedrugbyId(String id) {
		
		Optional<Drugs> response = drugsRepository.findById(id);
		
		if(response.isPresent()) {
			drugsRepository.deleteById(id);
			return true;
		}
		
		return false;
		
	}
	
	
	// Update Drug Price
	
	public boolean updateDrugprice(String id, double price) {
		
		Optional<Drugs> response = drugsRepository.findById(id);
		
		if(response.isPresent()) {
			response.get().setDrugPrice(price);
			drugsRepository.save(response.get());
			return true;
		}
		
		return false;
	}


}
