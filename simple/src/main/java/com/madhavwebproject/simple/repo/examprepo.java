package com.madhavwebproject.simple.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entities.Example;
@Repository
public interface examprepo extends JpaRepository<Example, Integer> {
 @Query(value="select count(*) from developer ",nativeQuery = true)
 public int  countdeveloper();
 @Query(value="select max(salary) from developer",nativeQuery = true)
 public int findmax();
 @Query(value="select min(salary) from developer",nativeQuery = true)
 public int findmin();
 @Query(value="select salary from developer", nativeQuery = true)
 public List<Double> getsalary();
 @Query(value="select name from developer where id=:id", nativeQuery = true)
 public List<String> getname(int id);
 @Query(value="select name from developer where salary=:salary", nativeQuery = true)
 public List<String> getnameofsalary(double salary);
 
}
