package com.desafioproductos.demo.repositories.interfaces;

import com.desafioproductos.demo.dtos.PurchaseTicketDto;

import java.util.List;

public interface PurchaseRequestRepository {

    List<PurchaseTicketDto> getPurchaseTickets();
    PurchaseTicketDto getPurchaseTicketByCustomer(Integer CustomerId);
    PurchaseTicketDto updateTicket(PurchaseTicketDto existingTicket, PurchaseTicketDto newData);
    PurchaseTicketDto addNewTicket(PurchaseTicketDto ticket);
    PurchaseTicketDto getPurchaseTicketById(Integer ticketId);
}
