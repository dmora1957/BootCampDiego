package com.consultoriodentista.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class DairyDTO {

    private Long id;
    private Date startTime;
    private Date endTime;
    private DentistDTO dentist;
}
