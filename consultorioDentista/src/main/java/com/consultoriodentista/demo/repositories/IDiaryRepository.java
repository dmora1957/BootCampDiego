package com.consultoriodentista.demo.repositories;

import com.consultoriodentista.demo.entities.Dairy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaryRepository extends JpaRepository<Dairy, Long> {
}
