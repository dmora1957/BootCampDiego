package com.studentdraw.demo.services;


import com.studentdraw.demo.entities.Student;

public interface IStudentService {
    Long generateStudents(Integer quantity);
    Iterable<Student> returnStudentDraw(Integer quantity);
}
