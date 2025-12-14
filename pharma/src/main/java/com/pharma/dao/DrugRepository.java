package com.pharma.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.entity.Drugs;

@Repository
public interface DrugRepository extends JpaRepository<Drugs, String> {
	
	

}
