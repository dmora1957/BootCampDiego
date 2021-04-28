package com.appconsultoriomysql.demo.services;

import com.appconsultoriomysql.demo.entities.Student;
import com.appconsultoriomysql.demo.entities.User;
import com.appconsultoriomysql.demo.repositories.interfaces.IStudentRepository;
import com.appconsultoriomysql.demo.repositories.interfaces.IUserRepository;
import com.appconsultoriomysql.demo.services.interfaces.IStudentService;
import com.appconsultoriomysql.demo.services.interfaces.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    public final IUserRepository repo;

    public UserService(IUserRepository repo) {
        this.repo = repo;
    }

    @Transactional
    @Override
    public User save(User student) { return repo.save(student); }

    @Transactional
    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<User> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return repo.findById(id).orElse(null);
    }

}
