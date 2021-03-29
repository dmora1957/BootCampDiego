package com.company;

public class Auto extends Vehiculo{

    public Auto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.ruedas=4;
        this.peso = 1000;
    }
}
