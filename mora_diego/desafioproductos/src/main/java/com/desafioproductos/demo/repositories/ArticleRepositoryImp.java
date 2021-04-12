package com.desafioproductos.demo.repositories;

import com.desafioproductos.demo.dtos.ArticleDto;
import com.desafioproductos.demo.exceptions.ArticleNotFoundException;
import com.desafioproductos.demo.exceptions.FileLoadException;
import com.desafioproductos.demo.exceptions.GenericException;
import com.desafioproductos.demo.helpers.FileHandler;
import com.desafioproductos.demo.repositories.interfaces.ArticleRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ArticleRepositoryImp implements ArticleRepository {

    private ArrayList<ArticleDto> articles = null;

    public ArticleRepositoryImp() throws GenericException {
        this.loadDataBase();
    }

    /**
     * get all articles from database file
     * @return an array list with all the articles
     */
    @Override
    public ArrayList<ArticleDto> getAllArticles() throws GenericException {
        return  articles;
    }

    /**
     * gets one article by its identifier
     * @param productId article identifier to search
     * @throws ArticleNotFoundException when article is not found
     * @return a single article
     */
    @Override
    public ArticleDto findById(Integer productId) throws GenericException {
        ArticleDto result = null;
        Optional<ArticleDto> item = this.articles.stream()
                .filter(priceDto -> priceDto.getProductId().equals(productId))
                .findFirst();

        if(item.isPresent())
            result = item.get();

        return result;
    }

    /**
     * update articles stock
     * @param product product to update stock
     * @param quantity to update
     * @param isIncreaseMovement flag to determine if must increase or decrease
     */
    @Override
    public void changeStock(ArticleDto product, Integer quantity, boolean isIncreaseMovement) {
         var index = this.articles.indexOf(product);
         this.articles.get(index).changeQuantity(isIncreaseMovement ? quantity : -quantity);
    }

    /**
     * parse collection to comma separated data
     * @return List with rows
     */
    private List<String> getRows() {
        List<String> rows = new ArrayList<>();
        rows.add("productId,name,category,brand,price,quantity,freeShipping,prestige");
        for (var article:articles) {
            rows.add(article.parseToCsvRow());
        }
        return rows;
    }

    /**
     * Update database
     */
    private void UpdateDatabase() throws GenericException {
        FileHandler.saveToDataBase("dbProductos.csv", this.getRows());
    }

    /**
     * set the articles in memory list with the data got from database
     * @throws FileLoadException when there is an error loading data base file
     */
    private void loadDataBase() throws GenericException {
        var records = FileHandler.readDataBaseFile("dbProductos.csv");
        this.articles = ParseData(records);
    }

    /**
     * Parse data obtained from the database file into a dto list
     * @return a list of Article dto
     * @throws FileLoadException when there is an error loading data base file
     */
    private ArrayList<ArticleDto> ParseData(List<List<String>> records) throws FileLoadException {
        ArrayList<ArticleDto> result = new ArrayList<>();
        try{
            for(int i = 1; i<records.size(); i++)
            {
                var values = records.get(i);
                double price = Double.parseDouble(values.get(4).replace("$","").replace(".",""));
                int quantity = Integer.parseInt(values.get(5));
                boolean freeShipping = true;
                if(values.get(6).equalsIgnoreCase("NO"))
                    freeShipping = false;
                result.add(new ArticleDto(Integer.parseInt(values.get(0)),values.get(1), values.get(2),values.get(3), price,quantity, freeShipping, values.get(7)));
            }
        }
        catch(Exception ex)
        {
            throw new FileLoadException(ex.getMessage());
        }
        return  result;
        //return getFakeLoad();
    }

    private ArrayList<ArticleDto> getFakeLoad() {
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
}
