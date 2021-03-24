package com.company.Figuras;

public class Triangulo extends FiguraGeometrica{

    private int alto;
    private int base;

    @Override
    public double area() {
        return (this.alto*this.base)/2;
    }
}
