package com.madhavwebproject.simple.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entities.Userdetails;

@Repository
public interface Userdetailsrepo extends JpaRepository<Userdetails, Integer> {
	@Query(value="select u1_0.id, u1_0.name, u1_0.password ,u1_0.roles from userdetails u1_0 where name=:name",nativeQuery = true)
 Userdetails findbyname(String name);

}
