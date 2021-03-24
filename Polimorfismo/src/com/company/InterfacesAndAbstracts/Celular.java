package com.company.InterfacesAndAbstracts;

public class Celular implements Precedable<Celular>{
    private int numero;
    private String titular;

    public Celular() {
    }

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public boolean precedeA(Celular o) {
        return this.numero < o.numero;
    }
}
