package com.studentdraw.demo.repositories;

import com.studentdraw.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {

    @Query(value = "SELECT max(id) FROM Student")
    public Long maxIdentifier();
}
