package com.appconsultoriomysql.demo.services.interfaces;

import com.appconsultoriomysql.demo.entities.Privilege;
import com.appconsultoriomysql.demo.entities.Role;

public interface IPrivilegeService {
    Privilege save(Privilege user);
    void delete(Long id);
    Iterable<Privilege> findAll();
    Privilege findById(Long id);
}
