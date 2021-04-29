package com.consultoriodentista.demo.repositories;

import com.consultoriodentista.demo.entities.Dairy;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.entities.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {

    List<Turn> findByDairyId(Long dairyId);
    List<Turn> findByDayGreaterThanEqualAndDayLessThan(Date from, Date to);
    List<Turn> findByTurnStatus(TurnStatus status);
    List<Turn> findByDairyIn(Collection<Dairy> dairies);
    List<Turn> findByTurnStatusAndDayGreaterThanEqualAndDayLessThan(TurnStatus status,Date from, Date to);
    @Query("SELECT t.dairy FROM Turn t WHERE t.day >= :from and t.day < :to GROUP BY t.dairy having count (t.dairy) > 2")
    List<Dairy> groupByDairy(Date from, Date to);
}
