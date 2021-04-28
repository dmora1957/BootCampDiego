package com.consultoriodentista.demo.repositories;

import com.consultoriodentista.demo.entities.Patient;
import com.consultoriodentista.demo.entities.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnStatusRepository extends JpaRepository<TurnStatus, Long> {
}
