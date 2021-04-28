package com.consultoriodentista.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class TurnDTO {

    private Long id;
    private Date day;
    private Long dairyId;
    private Long turnStatusId;
    private Long patientId;
}
