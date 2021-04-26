package com.desafioproductos.demo.fixtures;

import com.desafioproductos.demo.dtos.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ArticleDtoFixture {

    public static ArrayList<ArticleDto> getArticles(Integer quantity)
    {
        ArrayList<ArticleDto> result = new ArrayList<>();
        int counter=0;
        ArrayList<ArticleDto> allArticles =getArticles();
        Collections.shuffle(allArticles);
        while(counter < quantity && counter < allArticles.size())
        {
            result.add(allArticles.get(counter));
            counter++;
        }
        return result;
    }

    public static ArrayList<ArticleDto> getArticles() {
        ArrayList<ArticleDto> result = new ArrayList<>();
        result.add(new ArticleDto(1,"Desmalezadora", "Herramientas","Makita", 9600.00,5,true,"****"));
        result.add(new ArticleDto(2,"Taladro", "Herramientas","Black & Decker", 12500.00,7,true,"****"));
        result.add(new ArticleDto(3,"Desmalezadora", "Herramientas","Black & Decker", 7215.00,10,true,"***"));
        result.add(new ArticleDto(4,"Zapatillas Deportivas", "Deportes","Nike", 14000.00,4,true,"*****"));
        result.add(new ArticleDto(5,"Zapatillas Deportivas", "Deportes","Adidas", 13650.00,6,true,"*****"));
        result.add(new ArticleDto(6,"Camiseta", "Deportes","Topper", 2300.00,2,false,"***"));
        result.add(new ArticleDto(7,"Redmi Note 9", "Celulares","Xiaomi", 40000.00,15,true,"****"));
        result.add(new ArticleDto(8,"Smartwatch", "Celulares","Noga", 1900.00,20,false,"**"));
        result.add(new ArticleDto(9,"Remera", "Indumentaria","Taverniti", 2300.00,2,false,"***"));
        result.add(new ArticleDto(10,"Chomba", "Indumentaria","Taverniti", 2400.00,6,false,"***"));
        result.add(new ArticleDto(11,"Medias", "Indumentaria","Mistral", 500.00,8,false,"*"));
        result.add(new ArticleDto(12,"Short", "Indumentaria","Lacoste", 3900.00,9,true,"***"));
        return  result;
    }

    public static ArrayList<ArticleDto> getByCategory(String category)
    {
      return getArticles().stream().filter(x -> x.getCategory().equalsIgnoreCase(category)).collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<ArticleDto> getByBrand(String brand)
    {
        return getArticles().stream().filter(article -> article.getBrand().toUpperCase(Locale.ROOT).contains(brand.toUpperCase(Locale.ROOT)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<ArticleDto> getByName(String brand)
    {
        return getArticles().stream().filter(article -> article.getName().toUpperCase(Locale.ROOT).contains(brand.toUpperCase(Locale.ROOT)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<ArticleDto> getByFreeShipping(boolean fs)
    {
        return getArticles().stream().filter(article -> article.getFreeShipping().equals(fs))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<ArticleDto> getByPrestige(String prestige)
    {
        return getArticles().stream().filter(article -> article.getPrestige().equals(prestige))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
