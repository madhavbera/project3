package com.madhavwebproject.simple.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.Entities.Department;
import com.Entities.Employe;

@Repository
public interface Emprepo extends JpaRepository<Employe, Integer> {
//	@Query("select * from Department d")
//	public Department getall();
	@Query("select e from Employe  e"+
           " where e.id=:id")
	public Employe getidemp(int id); 
	


}

