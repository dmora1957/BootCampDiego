package com.desafioproductos.demo.services;

import com.desafioproductos.demo.dtos.*;
import com.desafioproductos.demo.exceptions.*;
import com.desafioproductos.demo.repositories.interfaces.ArticleRepository;
import com.desafioproductos.demo.repositories.interfaces.CustomerRepository;
import com.desafioproductos.demo.repositories.interfaces.PurchaseRequestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRequestService {

    private final ArticleRepository _repository;
    private final PurchaseRequestRepository _purchaseRequestRepository;
    private final CustomerRepository _customerRepository;
    private long Integer = 0;
    public PurchaseRequestService(ArticleRepository repository, PurchaseRequestRepository purchaseRequestRepository, CustomerRepository customerRepository) {
        this._purchaseRequestRepository = purchaseRequestRepository;
        this._customerRepository = customerRepository;
        this._repository = repository;
    }

    /**
     * Generates and validates a purchase request
     * @param request object with the purchase request
     * @return an array list with article dto
     * @throws ArticleNotFoundException when an article is not found
     * @throws NotEnoughStockException when the requested quantity is greater than the available stock
     */
    public PurchaseTicketResponseDto addPurchaseRequest(PurchaseRequestDto request) throws GenericException {
        this.validatesRequest(request);
        this.validatesCustomer(request.getCustomerId());
        var ticket = this.generateTicket(request);
        var statusCode = new StatusCodeResponseDto(HttpStatus.OK.toString(), "Solicitud de compra realizada con exito");
        return new PurchaseTicketResponseDto(ticket,statusCode);
    }

    /**
     * validates new request
     * @param newRequest new request object
     */
    private PurchaseTicketDto generateTicket(PurchaseRequestDto newRequest) throws GenericException {
        PurchaseTicketDto resultTicket = null;
        PurchaseTicketDto existingTicket = null;
       if(newRequest.getCustomerId() != null) {
           existingTicket = this._purchaseRequestRepository.getPurchaseTicketByCustomer(newRequest.getCustomerId());
       }
        var total = this.getTotalPrice(newRequest.getArticles());
        var newData = new PurchaseTicketDto(total, newRequest.getCustomerId(), newRequest.getArticles());

       if(existingTicket != null){
           resultTicket = _purchaseRequestRepository.updateTicket(existingTicket, newData);
       }
       else {
           resultTicket = _purchaseRequestRepository.addNewTicket(newData);
       }
        return resultTicket;
    }

    /**
     * validates new request
     * @param newRequest new request object
     */
    private void validatesRequest(PurchaseRequestDto newRequest) throws GenericException {
        if(newRequest.getArticles() == null || newRequest.getArticles().isEmpty())
            throw new MissedDataException("Missing request articles");
    }

    /**
     * validates new request
     * @param customerId new request object
     */
    private void validatesCustomer(Integer customerId) throws GenericException {
        if(customerId != null)
        {
            var customer = _customerRepository.findCustomerById(customerId);
            if(customer == null)
                throw new CustomerNotFoundException(customerId);
        }
    }

    /**
     * Gets and validates the articles
     * @param requestArticles request article list
     * @return an array list with valid articles found
     * @throws ArticleNotFoundException when an article is not found
     * @throws NotEnoughStockException when the requested quantity is greater than the available stock
     */
    public Double getTotalPrice(List<PurchaseRequestArticleDto> requestArticles) throws GenericException {
        double total = 0.0;
        for (var ra : requestArticles) {
            ArticleDto currentArticle = this._repository.findById(ra.getProductId());
            if(currentArticle == null)
                throw new ArticleNotFoundException(ra.getProductId());
            this.moveStock(currentArticle, ra.getQuantity());
            total += ra.getQuantity() * currentArticle.getDoublePrice();
        }
        return total;
    }

    /**
     * Generates stock movement
     * @param currentArticle request article list
     * @param soldQuantity request article quantity
     * @throws ArticleNotFoundException when an article is not found
     * @throws NotEnoughStockException when the requested quantity is greater than the available stock
     */
    public void moveStock(ArticleDto currentArticle, Integer soldQuantity) throws GenericException {
        double total = 0.0;

        if(currentArticle.getQuantity() < soldQuantity)
            throw new NotEnoughStockException(currentArticle.getName());

        this._repository.changeStock(currentArticle, soldQuantity, false);
    }

    public TicketsCollectionResponseDto getTickets() {
        String responseMessage = "Lista obtenida correctamente";
        var result = _purchaseRequestRepository.getPurchaseTickets();
        if(result.isEmpty())
            responseMessage = "No hay datos";

        return new TicketsCollectionResponseDto(result,responseMessage);
    }

    public PurchaseTicketResponseDto getTicketById(Integer ticketId) {
        var result = _purchaseRequestRepository.getPurchaseTicketById(ticketId);

        var statusCode = new StatusCodeResponseDto(HttpStatus.OK.toString(), "Ticket Obtenido correctamente");
        return new PurchaseTicketResponseDto(result,statusCode);
    }
}
