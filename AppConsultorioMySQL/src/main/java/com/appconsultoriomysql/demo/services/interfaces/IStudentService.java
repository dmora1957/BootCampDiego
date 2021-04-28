package com.appconsultoriomysql.demo.services.interfaces;

import com.appconsultoriomysql.demo.entities.Student;
import com.appconsultoriomysql.demo.entities.User;

public interface IStudentService {
    Student save(Student user);
    void delete(Long id);
    Iterable<Student> findAll();
    Student findById(Long id);
}
