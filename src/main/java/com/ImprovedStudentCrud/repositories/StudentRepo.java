package com.ImprovedStudentCrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ImprovedStudentCrud.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
