package com.madhavwebproject.simple.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entities.Btech;
import com.Entities.Department;

import jakarta.transaction.Transactional;

@Repository
public interface Deptrepo extends JpaRepository<Department, Integer>{

	@Query("select d from Department d")
	public List<Department> getall();
//	@Modifying
//
//	@Transactional
//	@Query("delete from Bca")
//	public void deletebca();
	@Modifying
	@Transactional
	@Query("delete from Department")
	public void deleteall();
//	@Query("select d from Department d "+" where d.id=:id")
//	public Department getiddep(int id);
	@Query(value ="select * from dept"+" where id=:id",nativeQuery=true)
	public Department getiddeponly(@Param("id") int id);

}
