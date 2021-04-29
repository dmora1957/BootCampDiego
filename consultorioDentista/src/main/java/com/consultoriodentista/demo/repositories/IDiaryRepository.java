package com.consultoriodentista.demo.repositories;

import com.consultoriodentista.demo.entities.Dairy;
import com.consultoriodentista.demo.entities.Dentist;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.entities.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiaryRepository extends JpaRepository<Dairy, Long> {
    List<Dairy> findByDentist(Dentist dentist);
}
