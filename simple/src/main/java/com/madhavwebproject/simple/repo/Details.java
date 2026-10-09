package com.madhavwebproject.simple.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entities.Course;

@Repository
public interface Details extends JpaRepository<Course, Integer> {

}
