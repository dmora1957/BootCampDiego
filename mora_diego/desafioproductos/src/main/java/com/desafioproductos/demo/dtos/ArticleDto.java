package com.desafioproductos.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Data
@AllArgsConstructor
public class ArticleDto{
    private Integer ProductId;
    private String Name;
    private String Category;
    private String Brand;
    private Double Price;
    private Integer Quantity;
    private Boolean FreeShipping;
    private String Prestige;

    public String getPrice() {
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return dollarFormat.format(Price);
    }
    public Double getDoublePrice() {
        return Price;
    }

    public void changeQuantity(int i) {
        this.Quantity += i;
    }

    public String parseToCsvRow() {
        return String.join(",",ProductId.toString(), Name, Category, Brand, getPrice(), Quantity.toString(),FreeShipping?"SI":"NO",Prestige);
    }
}
