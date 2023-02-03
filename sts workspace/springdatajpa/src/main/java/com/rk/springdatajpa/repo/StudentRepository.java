package com.rk.springdatajpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
