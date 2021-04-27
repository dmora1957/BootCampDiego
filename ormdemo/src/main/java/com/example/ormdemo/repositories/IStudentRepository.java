package com.example.ormdemo.repositories;

import com.example.ormdemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {

}
