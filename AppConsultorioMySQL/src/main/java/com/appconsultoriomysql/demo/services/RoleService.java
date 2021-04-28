package com.appconsultoriomysql.demo.services;

import com.appconsultoriomysql.demo.entities.Role;
import com.appconsultoriomysql.demo.entities.Student;
import com.appconsultoriomysql.demo.repositories.interfaces.IRoleRepository;
import com.appconsultoriomysql.demo.repositories.interfaces.IStudentRepository;
import com.appconsultoriomysql.demo.services.interfaces.IRoleService;
import com.appconsultoriomysql.demo.services.interfaces.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService implements IRoleService {

    public final IRoleRepository repo;

    public RoleService(IRoleRepository repo) {
        this.repo = repo;
    }

    @Transactional
    @Override
    public Role save(Role student) {
        return repo.save(student);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Role> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Role findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Role findByName(String name) {
        return null;
    }
}
