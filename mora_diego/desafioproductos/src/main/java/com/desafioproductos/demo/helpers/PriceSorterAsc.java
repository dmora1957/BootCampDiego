package com.desafioproductos.demo.helpers;

import com.desafioproductos.demo.dtos.ArticleDto;

import java.util.Comparator;

public class PriceSorterAsc implements Comparator<ArticleDto>
{
    @Override
    public int compare(ArticleDto o1, ArticleDto o2) {
        return o1.getDoublePrice().compareTo(o2.getDoublePrice());
    }
}
