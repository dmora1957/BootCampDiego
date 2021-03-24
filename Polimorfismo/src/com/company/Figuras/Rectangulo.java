package com.company.Figuras;

public class Rectangulo extends FiguraGeometrica{

    private int alto;
    private int largo;

    @Override
    public double area() {
        return alto*largo;
    }
}
