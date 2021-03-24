package com.company.Figuras;

public class Circulo extends FiguraGeometrica
{
    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return this.radio*this.radio*Math.PI;
    }
}
