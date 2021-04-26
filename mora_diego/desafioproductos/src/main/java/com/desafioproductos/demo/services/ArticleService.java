package com.desafioproductos.demo.services;

import com.desafioproductos.demo.dtos.ArticleDto;
import com.desafioproductos.demo.dtos.ArticlesCollectionResponseDto;
import com.desafioproductos.demo.dtos.FilterDto;
import com.desafioproductos.demo.exceptions.EmptyResponseException;
import com.desafioproductos.demo.exceptions.FileLoadException;
import com.desafioproductos.demo.exceptions.FilterNotValidException;
import com.desafioproductos.demo.exceptions.GenericException;
import com.desafioproductos.demo.helpers.*;
import com.desafioproductos.demo.repositories.interfaces.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private ArticleRepository _repository;

    public ArticleService(ArticleRepository repository) {
        this._repository = repository;
    }

    /**
     * Search articles by filter and order, none of the filters are required, a maximum of 2 filters can be used
     * @param filter object with the filter values
     * @return an array list with article dto
     * @throws FileLoadException with the error while loading data file
     * @throws FilterNotValidException with filter validation error
     * @throws EmptyResponseException when there is no data to return
     */
    public ArticlesCollectionResponseDto getArticles(FilterDto filter) throws GenericException {

        String responseMessage = "Lista obtenida correctamente";
        FilterValidator.validateFilter(filter);

        var articleList =  _repository.getAllArticles();

        articleList = filterCollection(articleList, filter);

        if(articleList.isEmpty())
            responseMessage = "No hay datos para esta busqueda";

        articleList = sortCollection(articleList, filter);

        return new ArticlesCollectionResponseDto(articleList,responseMessage);
    }

    /**
     * Executes the search filtering
     * @param articleList all the articles
     * @param filter object with the filter values
     * @return a filtered array list with article dto
     */
    public List<ArticleDto> filterCollection(List<ArticleDto> articleList, FilterDto filter){

        if(filter.getBrand()!= null)
            articleList = articleList.stream().filter(article -> article.getBrand().toUpperCase(Locale.ROOT).contains(filter.getBrand().toUpperCase(Locale.ROOT)))
                    .collect(Collectors.toList());

        if(filter.getCategory()!= null)
            articleList = articleList.stream().filter(article -> article.getCategory().toUpperCase(Locale.ROOT).contains(filter.getCategory().toUpperCase(Locale.ROOT)))
                    .collect(Collectors.toList());

        if(filter.getName()!= null)
            articleList = articleList.stream().filter(article -> article.getName().toUpperCase(Locale.ROOT).contains(filter.getName().toUpperCase(Locale.ROOT)))
                    .collect(Collectors.toList());

        if(filter.getFreeShipping()!= null)
            articleList = articleList.stream().filter(article -> article.getFreeShipping().equals(filter.getFreeShipping()))
                    .collect(Collectors.toList());

        if(filter.getPrestige()!= null)
            articleList = articleList.stream().filter(article -> article.getPrestige().equals(filter.getPrestige()))
                    .collect(Collectors.toList());

        return articleList;
    }

    /**
     * Executes the collection sorting
     * @param articleList all the articles
     * @param filter object with the order value
     * @return a sorted array list with article dto
     */
    public List<ArticleDto> sortCollection(List<ArticleDto> articleList, FilterDto filter){
        try {
            if (filter.getOrder() == null || articleList.size() <= 1)
                return articleList;

            switch (filter.getOrder()) {
                case 0: {
                    articleList.sort(new ArticleNameSorterAsc());
                    break;
                }
                case 1: {
                    articleList.sort(new ArticleNameSorterDesc());
                    break;
                }
                case 2: {
                    articleList.sort(new PriceSorterDesc());
                    break;
                }
                case 3: {
                    articleList.sort(new PriceSorterAsc());
                    break;
                }
            }
            return articleList;
        }catch (Exception ex)
        {ex.printStackTrace();}

        return  null;
    }
}
