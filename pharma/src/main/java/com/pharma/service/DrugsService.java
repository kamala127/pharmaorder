package com.pharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.dao.DrugRepository;

@Service
public class DrugsService {
	
	@Autowired
	private DrugRepository drugsRepository;
	
	
	

}
