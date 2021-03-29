package com.company;

public class Moto extends Vehiculo{

    public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.ruedas=2;
        this.peso = 300;
    }
}
