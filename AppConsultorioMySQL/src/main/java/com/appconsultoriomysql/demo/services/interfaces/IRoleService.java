package com.appconsultoriomysql.demo.services.interfaces;

import com.appconsultoriomysql.demo.entities.Role;
import com.appconsultoriomysql.demo.entities.Student;

public interface IRoleService {
    Role save(Role user);
    void delete(Long id);
    Iterable<Role> findAll();
    Role findById(Long id);
}
