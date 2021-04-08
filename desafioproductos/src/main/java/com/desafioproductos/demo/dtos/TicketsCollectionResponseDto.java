package com.desafioproductos.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketsCollectionResponseDto {
    private List<PurchaseTicketDto> data;
    private String message;
}
