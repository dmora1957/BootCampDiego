package com.company.Comparator;

public class Persona implements Precedable<Persona> {

    private String nombre;
    private int dni;

    public Persona() {
    }

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public boolean precedeA(Persona o) {
        return this.dni < o.dni;
    }
}
