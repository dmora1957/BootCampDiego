package com.appconsultoriomysql.demo.services;

import com.appconsultoriomysql.demo.entities.Student;
import com.appconsultoriomysql.demo.entities.User;
import com.appconsultoriomysql.demo.repositories.interfaces.IStudentRepository;
import com.appconsultoriomysql.demo.services.interfaces.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService implements IStudentService {

    public final IStudentRepository repo;

    public StudentService(IStudentRepository repo) {
        this.repo = repo;
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return repo.save(student);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Student> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Student findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
