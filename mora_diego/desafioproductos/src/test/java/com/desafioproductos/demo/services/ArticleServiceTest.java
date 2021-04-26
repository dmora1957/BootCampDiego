package com.desafioproductos.demo.services;

import com.desafioproductos.demo.dtos.ArticlesCollectionResponseDto;
import com.desafioproductos.demo.dtos.FilterDto;
import com.desafioproductos.demo.exceptions.GenericException;
import com.desafioproductos.demo.fixtures.ArticleDtoFixture;
import com.desafioproductos.demo.repositories.ArticleRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceTest {

    private ArticleService service;

    @Mock
    private static ArticleRepositoryImp repo;

    @BeforeEach
    void setUp() throws GenericException {
        repo = Mockito.mock(ArticleRepositoryImp.class);
        when(repo.getAllArticles()).thenReturn(ArticleDtoFixture.getArticles());
        this.service = new ArticleService(repo);
    }

    @Test
    public void getAll_OK() throws Exception
    {
        //scope
        Integer articlesQuantity = 4;
        var expectedList = ArticleDtoFixture.getArticles();
        //when(repo.getAllArticles()).thenReturn(expectedList);
        String responseMessage = "Lista obtenida correctamente";
        ArticlesCollectionResponseDto expectedResponse = new ArticlesCollectionResponseDto(expectedList, responseMessage);
        var emptyFilter = new FilterDto();
        var result = service.getArticles(emptyFilter);
        Assertions.assertNotNull(result);
        //assertEquals(articlesQuantity, result.getData().size());
        Assertions.assertEquals(responseMessage, result.getMessage());
        Assertions.assertIterableEquals(expectedResponse.getData(),result.getData());
    }

    @Test
    public void getFiltered_Empty() throws Exception
    {
        //scope
        String existingCategory = "Deportes";
        String nonExistingCategory = "CategoriaNoExistente";
        //when(repo.getAllArticles()).thenReturn(ArticleDtoFixture.getByCategory(existingCategory));
        String responseMessage = "No hay datos para esta busqueda";
        ArticlesCollectionResponseDto expectedResponse = new ArticlesCollectionResponseDto(new ArrayList<>(), responseMessage);
        var categoryFilter = new FilterDto();
        categoryFilter.setCategory(nonExistingCategory);
        var result = service.getArticles(categoryFilter);

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getData().isEmpty());
        Assertions.assertNotEquals(existingCategory, nonExistingCategory);
        Assertions.assertEquals(responseMessage, result.getMessage());

    }

    @Test
    public void getFiltered_Category() throws Exception
    {
        String category = "Deportes";
        String responseMessage = "Lista obtenida correctamente";
        ArticlesCollectionResponseDto expectedResponse = new ArticlesCollectionResponseDto(ArticleDtoFixture.getByCategory(category), responseMessage);
        var categoryFilter = new FilterDto();
        categoryFilter.setCategory(category);
        var result = service.getArticles(categoryFilter);

        Assertions.assertNotNull(result);
        //assertEquals(4, result.getData().size());
        Assertions.assertEquals(responseMessage, result.getMessage());
        Assertions.assertIterableEquals(expectedResponse.getData(),result.getData());
    }

    @Test
    public void getFiltered_Brand() throws Exception
    {
        String brand = "Adidas";
        //when(repo.getAllArticles()).thenReturn(ArticleDtoFixture.getByBrand(brand));
        String responseMessage = "Lista obtenida correctamente";
        ArticlesCollectionResponseDto expectedResponse = new ArticlesCollectionResponseDto(ArticleDtoFixture.getByBrand(brand), responseMessage);
        var categoryFilter = new FilterDto();
        categoryFilter.setBrand(brand);
        var result = service.getArticles(categoryFilter);

        Assertions.assertNotNull(result);
        //assertEquals(4, result.getData().size());
        Assertions.assertEquals(responseMessage, result.getMessage());
        Assertions.assertIterableEquals(expectedResponse.getData(),result.getData());
    }

    @Test
    public void getFiltered_Name() throws Exception
    {
        String name = "Taladro";
        //when(repo.getAllArticles()).thenReturn(ArticleDtoFixture.getByBrand(brand));
        String responseMessage = "Lista obtenida correctamente";
        ArticlesCollectionResponseDto expectedResponse = new ArticlesCollectionResponseDto(ArticleDtoFixture.getByName(name), responseMessage);
        var categoryFilter = new FilterDto();
        categoryFilter.setName(name);
        var result = service.getArticles(categoryFilter);

        Assertions.assertNotNull(result);
        //assertEquals(4, result.getData().size());
        Assertions.assertEquals(responseMessage, result.getMessage());
        Assertions.assertIterableEquals(expectedResponse.getData(),result.getData());
    }

    @Test
    public void getFiltered_Prestige() throws Exception
    {
        String prestige = "***";
        //when(repo.getAllArticles()).thenReturn(ArticleDtoFixture.getByBrand(brand));
        String responseMessage = "Lista obtenida correctamente";
        ArticlesCollectionResponseDto expectedResponse = new ArticlesCollectionResponseDto(ArticleDtoFixture.getByPrestige(prestige), responseMessage);
        var categoryFilter = new FilterDto();
        categoryFilter.setPrestige(prestige);
        var result = service.getArticles(categoryFilter);

        Assertions.assertNotNull(result);
        //assertEquals(4, result.getData().size());
        Assertions.assertEquals(responseMessage, result.getMessage());
        Assertions.assertIterableEquals(expectedResponse.getData(),result.getData());
    }

    @Test
    public void getFiltered_freeShipping() throws Exception
    {
        boolean freeShipping = true;
        //when(repo.getAllArticles()).thenReturn(ArticleDtoFixture.getByBrand(brand));
        String responseMessage = "Lista obtenida correctamente";
        ArticlesCollectionResponseDto expectedResponse = new ArticlesCollectionResponseDto(ArticleDtoFixture.getByFreeShipping(freeShipping), responseMessage);
        var categoryFilter = new FilterDto();
        categoryFilter.setFreeShipping(freeShipping);
        var result = service.getArticles(categoryFilter);

        Assertions.assertNotNull(result);
        //assertEquals(4, result.getData().size());
        Assertions.assertEquals(responseMessage, result.getMessage());
        Assertions.assertIterableEquals(expectedResponse.getData(),result.getData());
    }

    @Test
    void filterCollection() {
    }

    @Test
    void sortCollection() {
    }
}