package com.ATM.MANAGEMENT.SYSTEM.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ATM.MANAGEMENT.SYSTEM.demo.entity.ATM;

@Repository
public interface Myrepo extends JpaRepository<ATM,Integer> {
	@Query(value="select * from atm where id=:id",nativeQuery = true)
	 public ATM getatmdata(@Param("id") int id);

}
