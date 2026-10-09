package com.ATM.MANAGEMENT.SYSTEM.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ATM.MANAGEMENT.SYSTEM.demo.entity.Userinfo;

@Repository
public interface Userrepo extends JpaRepository<Userinfo, Integer>{
	@Query(value="select u1_0.id, u1_0.name, u1_0.password ,u1_0.roles from userinfo u1_0 where name=:name",nativeQuery = true)
	Userinfo findbyname(String name);

}
