package com.company;

import com.company.InterfacesAndAbstracts.Persona;
import com.company.InterfacesAndAbstracts.SortUtil;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Persona[] personas = new Persona[]{
                new Persona("Diego Mora",50552116),
                new Persona("Paulina Bach",44750083),
                new Persona("Martin Jara",62549872),
                new Persona("Yaquelin Correa",26539876)
        };

        SortUtil.ordenar(personas);

    }
}
