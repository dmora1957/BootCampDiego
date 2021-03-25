package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    public HashMap<Integer, List<Prenda>> dictionary;

    public int identifierCounter;

    public GuardaRopa() {
        this.dictionary = new HashMap<>();
        this.identifierCounter = 0;
    }

    public int guardarPrenda(List<Prenda> listaDePrenda)
    {
        this.identifierCounter++;
        if(dictionary.containsKey(this.identifierCounter))
        {
            dictionary.get(this.identifierCounter).addAll(listaDePrenda);
        }
        else
        {
            dictionary.put(this.identifierCounter, listaDePrenda);
        }
        return this.identifierCounter;
    }

    public void mostrarPrendas()
    {
        for (int posicion: dictionary.keySet()) {
            System.out.println("En identificador: "+ posicion + " están las siguientes prendas:");

            for (var prenda:dictionary.get(posicion)) {
                System.out.println("- " + prenda.marca + " / "+prenda.modelo);
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero)
    {
        if(dictionary.containsKey(numero))
        {
            return dictionary.get(numero);
        }
        else
        {
            return  null;
        }
    }
}
