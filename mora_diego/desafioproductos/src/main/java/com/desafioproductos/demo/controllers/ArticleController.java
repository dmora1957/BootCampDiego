package com.desafioproductos.demo.controllers;

import com.desafioproductos.demo.dtos.FilterDto;
import com.desafioproductos.demo.exceptions.EmptyResponseException;
import com.desafioproductos.demo.exceptions.FileLoadException;
import com.desafioproductos.demo.exceptions.FilterNotValidException;
import com.desafioproductos.demo.exceptions.GenericException;
import com.desafioproductos.demo.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService _service;

    public ArticleController(ArticleService service) {
        this._service = service;
    }

    /**
     * Search articles by filter and order, none of the filters are required, a maximum of 2 filters can be used
     * @param id (Integer) the article identifier filter
     * @param product (String) the article name filter
     * @param brand (String) the article brand filter
     * @param category (String) the article category filter
     * @param freeShipping (boolean) the article free shipping flag filter
     * @param prestige (String) the article prestige filter
     * @param order (Integer) order type of the collection response: 0 Name Asc, 1 Name Desc, 2 Price Desc, 3 Price Asc
     * @return 200 status code with the article collection
     * @throws FileLoadException 500 status code with the message of the error while loading data file
     * @throws FilterNotValidException 400 status code with filter validation error
     * @throws EmptyResponseException 200 status code with the message "there is no data to return"
     */
    @GetMapping()
    public ResponseEntity getArticles(@RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) String product,
                                      @RequestParam(required = false) String brand,
                                      @RequestParam(required = false) String category,
                                      @RequestParam(required = false) Boolean freeShipping,
                                      @RequestParam(required = false) String prestige,
                                      @RequestParam(required = false) Integer order) throws GenericException {
        return new ResponseEntity<>(this._service.getArticles(new FilterDto(id, product, category, brand, freeShipping, prestige, order)), HttpStatus.OK);
    }


}
