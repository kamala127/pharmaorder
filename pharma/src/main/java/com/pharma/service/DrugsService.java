package com.pharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	

}
