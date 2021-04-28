package com.appconsultoriomysql.demo.services;

import com.appconsultoriomysql.demo.entities.Privilege;
import com.appconsultoriomysql.demo.entities.Role;
import com.appconsultoriomysql.demo.entities.Student;
import com.appconsultoriomysql.demo.repositories.interfaces.IPrivilegeRepository;
import com.appconsultoriomysql.demo.repositories.interfaces.IStudentRepository;
import com.appconsultoriomysql.demo.services.interfaces.IPrivilegeService;
import com.appconsultoriomysql.demo.services.interfaces.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrivilegeService implements IPrivilegeService {

    public final IPrivilegeRepository repo;

    public PrivilegeService(IPrivilegeRepository repo) {
        this.repo = repo;
    }

    @Transactional
    @Override
    public Privilege save(Privilege student) {
        return repo.save(student);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Privilege> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Privilege findById(Long id) {
        return repo.findById(id).orElse(null);
    }
    public Privilege findByName(String name) {
        return null;
    }
}
