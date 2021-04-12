package com.desafioproductos.demo.controllers;

import com.desafioproductos.demo.dtos.PurchaseRequestDto;
import com.desafioproductos.demo.dtos.PurchaseTicketResponseDto;
import com.desafioproductos.demo.dtos.TicketsCollectionResponseDto;
import com.desafioproductos.demo.exceptions.*;
import com.desafioproductos.demo.services.PurchaseRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase-request")
public class PurchaseController {
    private final PurchaseRequestService _service;

    public PurchaseController(PurchaseRequestService service) {
        this._service = service;
    }

    /**
     * Generates a purchase request
     * @param request the request object with articles and quantities
     * @return 200 status code with a PurchaseTicketResponseDto
     * @throws FileLoadException 500 status code with the message of the error while loading data file
     * @throws ArticleNotFoundException 404 status code with not found id
     */
    @PostMapping()
    public ResponseEntity getArticles(@RequestBody PurchaseRequestDto request) throws GenericException {
        return new ResponseEntity<PurchaseTicketResponseDto>(this._service.addPurchaseRequest(request), HttpStatus.OK);
    }

    /**
     * Gets a ticket by its id
     * @param ticketId the request object with articles and quantities
     * @return 200 status code with a PurchaseTicketResponseDto
     */
    @GetMapping("/{ticketId}")
    public ResponseEntity getArticleById(@PathVariable Integer ticketId) throws GenericException {
        return new ResponseEntity<PurchaseTicketResponseDto>(this._service.getTicketById(ticketId), HttpStatus.OK);
    }

    /**
     * Gets all tickets
     * @return 200 status code with a TicketsCollectionResponseDto
     */
    @GetMapping()
    public ResponseEntity getArticles() throws GenericException {
        return new ResponseEntity<TicketsCollectionResponseDto>(this._service.getTickets(), HttpStatus.OK);
    }
}
