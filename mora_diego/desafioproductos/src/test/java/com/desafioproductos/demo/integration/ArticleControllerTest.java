package com.desafioproductos.demo.integration;

import com.desafioproductos.demo.controllers.ArticleController;
import com.desafioproductos.demo.dtos.ArticlesCollectionResponseDto;
import com.desafioproductos.demo.exceptions.GenericException;
import com.desafioproductos.demo.services.ArticleService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@EnableWebMvc
class ArticleControllerTest {

    /*@InjectMocks
    ArticleController  articleController;*/

    @Mock
    ArticleService service;


    private MockMvc mvc;

    private ObjectMapper mapper;

    private static ArticlesCollectionResponseDto expectedResponse;

    @BeforeEach
    void setUp() throws IOException, GenericException {
        ArticleController articleController = Mockito.mock(ArticleController.class);
        mvc = MockMvcBuilders.standaloneSetup(articleController)
                //.setControllerAdvice(new RestExceptionHandler())
                .build();

        mapper = new ObjectMapper().findAndRegisterModules()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        service = Mockito.mock(ArticleService.class);
//        List<ArticleDto> productLists = Arrays.asList(ArticleDtoFixture.withDefaults1(),
//                ArticleDtoFixture.withDefaults2(),
//                ArticleDtoFixture.withDefaults3(),
//                ArticleDtoFixture.withDefaults4());
//        String responseMessage = "Lista obtenida correctamente";
//        ArticlesCollectionResponseDto response = new ArticlesCollectionResponseDto(productLists, responseMessage);
//        when(service.getArticles(any())).thenReturn(response);
    }

    @Test
    public void getAll_OK() throws Exception
    {
        MvcResult result = mvc.perform(get("/articles").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String serviceResponse = result.getResponse().getContentAsString();
        assertNotNull(serviceResponse);

        ArticlesCollectionResponseDto collectionResponse = mapper.readValue(serviceResponse, ArticlesCollectionResponseDto.class);

        assertNotNull(collectionResponse);
        assertEquals(4, collectionResponse.getData().size());
        assertEquals("Lista obtenida correctamente", collectionResponse.getMessage());
    }
}