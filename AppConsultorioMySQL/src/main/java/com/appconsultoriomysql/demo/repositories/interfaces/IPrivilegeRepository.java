package com.appconsultoriomysql.demo.repositories.interfaces;

import com.appconsultoriomysql.demo.entities.Privilege;
import com.appconsultoriomysql.demo.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IPrivilegeRepository extends CrudRepository<Privilege, Long> {
}
