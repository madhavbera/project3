package com.madhavwebproject.simple.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entities.Btech;

@Repository
public interface Btechrepo extends JpaRepository<Btech, Integer> {
	
}
