package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	var prendas = new ArrayList<Prenda>();
	prendas.add(new Prenda("Nike", "Total 90"));
        prendas.add(new Prenda("Adidas", "Modelo adidas 1"));
        prendas.add(new Prenda("Adidas", "Modelo adidads 2"));

        var gr = new GuardaRopa();

        var idGuardado = gr.guardarPrenda(prendas);

        gr.mostrarPrendas();

       var prendasDevueltas = gr.devolverPrendas(idGuardado);
    }
}
