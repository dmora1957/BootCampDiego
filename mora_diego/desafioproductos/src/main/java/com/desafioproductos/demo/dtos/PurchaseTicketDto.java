package com.desafioproductos.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTicketDto {
    private Integer id;
    private Integer customerId;
    private Double total;
    private List<PurchaseRequestArticleDto> articles;

    public PurchaseTicketDto(Integer id)
    {
        this.id = id;
    }

    public PurchaseTicketDto(Double total, Integer customerId, List<PurchaseRequestArticleDto> articles)
    {
        this.total = total;
        this.customerId = customerId;
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        PurchaseTicketDto c = (PurchaseTicketDto) o;

        return Double.compare(id, c.getId()) == 0;
    }
}
