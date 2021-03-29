package com.company;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    public int distancia;
    public int PremioEnDOlares;
    public String Nombre;
    public int CantidadDeVehiculosPermitidos;
    public List<Vehiculo> listaDeVehiculos;

    public Carrera(int distancia, int premioEnDOlares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        PremioEnDOlares = premioEnDOlares;
        Nombre = nombre;
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente)
    {
        this.listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente)
    {
        this.listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo)
    {
        this.listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente)
    {
       this.eliminarVehiculo(new Vehiculo(unaPatente));
    }

    public Vehiculo devolverGanador()
    {
        Vehiculo ganador = null;
        double resultado = 0;

        for (var v: this.listaDeVehiculos) {
            var currentResult = (v.velocidad * (v.aceleracion/2))/(v.anguloDeGiro*(v.peso-v.ruedas*100));
            if(currentResult>resultado)
            {
                resultado = currentResult;
                ganador = v;
            }
        }
        return ganador;
    }
}
