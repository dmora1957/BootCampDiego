package com.desafioproductos.demo.repositories.interfaces;

import com.desafioproductos.demo.dtos.ArticleDto;
import com.desafioproductos.demo.exceptions.GenericException;
import java.util.List;

public interface ArticleRepository {
    List<ArticleDto> getAllArticles() throws GenericException;
    ArticleDto findById(Integer productId) throws GenericException;
    void changeStock(ArticleDto product, Integer quantity, boolean isIncreaseMovement);
}
