package com.company;

import java.util.Objects;

public class Vehiculo {
    public int velocidad;
    public int aceleracion;
    public int anguloDeGiro;
    public String patente;
    public int peso;
    public int ruedas;

    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return patente.equals(vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente);
    }
}
