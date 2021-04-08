package com.desafioproductos.demo.repositories;

import com.desafioproductos.demo.dtos.PurchaseTicketDto;
import com.desafioproductos.demo.exceptions.GenericException;
import com.desafioproductos.demo.repositories.interfaces.PurchaseRequestRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PurchaseRequestRepositoryImp implements PurchaseRequestRepository {
    private ArrayList<PurchaseTicketDto> tickets = null;

    public PurchaseRequestRepositoryImp() throws GenericException {
        this.loadDataBase();

    }

    private void loadDataBase() {
        tickets = new ArrayList<>();
    }

    /**
     * Gets the current ticket identifier
     * @return an identifier
     */
    private Integer getId()
    {
        PurchaseTicketDto latestTicket = tickets
                .stream()
                .max(Comparator.comparing(PurchaseTicketDto::getId))
                .orElse(new PurchaseTicketDto(0));

        return latestTicket.getId()+1;
    }

    @Override
    public List<PurchaseTicketDto> getPurchaseTickets() {
        return tickets;
    }

    @Override
    public PurchaseTicketDto getPurchaseTicketByCustomer(Integer CustomerId) {
        PurchaseTicketDto result = null;
        Optional<PurchaseTicketDto> item = this.tickets.stream()
                .filter(priceDto -> priceDto.getCustomerId().equals(CustomerId))
                .findFirst();

        if(item.isPresent())
            result = item.get();

        return result;
    }

    @Override
    public PurchaseTicketDto updateTicket(PurchaseTicketDto existingTicket, PurchaseTicketDto newData) {
        var index = this.tickets.indexOf(existingTicket);
        var oldTotal = this.tickets.get(index).getTotal();
        this.tickets.get(index).setTotal(newData.getTotal() + oldTotal);
        var currentArticles = this.tickets.get(index).getArticles();
        for (var article:newData.getArticles()) {
            var currentIndex = currentArticles.indexOf(article);
            if(currentIndex >= 0)
            {
                var currentQty = currentArticles.get(currentIndex).getQuantity();
                currentArticles.get(currentIndex).setQuantity(currentQty+article.getQuantity());
            }
            else
            {
                currentArticles.add(article);
            }
            this.tickets.get(index).setArticles(currentArticles);
        }

        return this.tickets.get(index);
    }

    @Override
    public PurchaseTicketDto addNewTicket(PurchaseTicketDto ticket) {
        ticket.setId(this.getId());
        this.tickets.add(ticket);
        return ticket;
    }

    @Override
    public PurchaseTicketDto getPurchaseTicketById(Integer ticketId) {
        PurchaseTicketDto result = null;
        Optional<PurchaseTicketDto> item = this.tickets.stream()
                .filter(priceDto -> priceDto.getId().equals(ticketId))
                .findFirst();

        if(item.isPresent())
            result = item.get();

        return result;
    }
}
