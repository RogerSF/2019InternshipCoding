package com.roger.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; // more powerful repository than CrudRepository
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.roger.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	List<Alien> findByTech(String tech);
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 order by aname") // JPQL Query Statement
	List<Alien> findByTechSorted(String tech);
} 
