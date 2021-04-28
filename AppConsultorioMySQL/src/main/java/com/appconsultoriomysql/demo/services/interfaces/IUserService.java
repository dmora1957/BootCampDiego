package com.appconsultoriomysql.demo.services.interfaces;

import com.appconsultoriomysql.demo.entities.User;

public interface IUserService {
    User save(User user);
    void delete(Long id);
    Iterable<User> findAll();
    User findById(Long id);
}
