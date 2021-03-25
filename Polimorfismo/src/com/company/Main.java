package com.company;

import com.company.Comparator.Persona;
import com.company.Comparator.SortUtil;
import com.company.PracticoFactoria.MiFactory;
import com.company.PracticoFactoria.Sorter;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Persona[] personas = new Persona[]{
                new Persona("Diego Mora",50552116),
                new Persona("Paulina Bach",44750083),
                new Persona("Martin Jara",62549872),
                new Persona("Yaquelin Correa",26539876)
        };

       var sorter =  MiFactory.getInstance("sorter");
        Comparator <Persona> c = (a,b) -> b.getDni()-a.getDni();
        ((Sorter)sorter).sort(personas,c);
        //SortUtil.ordenar(personas);

        Comparator <Persona> c2 = (a,b) -> b.getDni()-a.getDni();
        SortUtil.ordenar(personas, c2);

        Comparator <Persona> c3 = (a,b) -> b.getNombre().compareTo(a.getNombre());
        SortUtil.ordenar(personas, c3);
    }
}
