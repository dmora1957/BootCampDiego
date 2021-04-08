package com.desafioproductos.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTicketResponseDto {
    private PurchaseTicketDto ticket;
    private StatusCodeResponseDto statusCode;
}
