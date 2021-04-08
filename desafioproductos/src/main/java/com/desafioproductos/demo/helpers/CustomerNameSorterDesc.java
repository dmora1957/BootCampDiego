package com.desafioproductos.demo.helpers;

import com.desafioproductos.demo.dtos.ArticleDto;
import com.desafioproductos.demo.dtos.CustomerDto;

import java.util.Comparator;

public class CustomerNameSorterDesc implements Comparator<CustomerDto>
{
    @Override
    public int compare(CustomerDto o1, CustomerDto o2) {
        return o2.getName().compareToIgnoreCase(o1.getName());
    }
}
