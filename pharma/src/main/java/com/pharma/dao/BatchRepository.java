package com.pharma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharma.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, String> {

}
