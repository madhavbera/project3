package com.madhavwebproject.simple.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entities.Bca;

import jakarta.transaction.Transactional;

@Repository
public interface Bcarepo extends JpaRepository<Bca, Integer> {
	@Modifying

	@Transactional
	@Query("delete from Bca")
	public void deletebca();
}
