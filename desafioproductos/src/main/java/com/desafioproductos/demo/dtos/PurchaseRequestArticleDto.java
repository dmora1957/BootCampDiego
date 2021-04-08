package com.desafioproductos.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequestArticleDto {
    private Integer productId;
    private String name;
    private String brand;
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        PurchaseRequestArticleDto c = (PurchaseRequestArticleDto) o;

        return Double.compare(productId, c.getProductId()) == 0;
    }
}
