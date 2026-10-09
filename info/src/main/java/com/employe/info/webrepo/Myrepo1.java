package com.employe.info.webrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

//import com.example.Entities.Student;
@Repository
public interface Myrepo1 extends JpaRepository<com.employe.info.Zentity.Student, Long>{

}