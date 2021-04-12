package com.desafioproductos.demo.helpers;

import com.desafioproductos.demo.dtos.ArticleDto;

import java.util.Comparator;

public class ArticleNameSorterDesc implements Comparator<ArticleDto>
{
    @Override
    public int compare(ArticleDto o1, ArticleDto o2) {
        return o2.getName().compareToIgnoreCase(o1.getName());
    }
}
