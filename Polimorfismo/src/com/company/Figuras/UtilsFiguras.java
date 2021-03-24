package com.company.Figuras;

public class UtilsFiguras {

    public static double areaPromedio(FiguraGeometrica[] figuras)
    {
        int contador = 0;
        double total = 0;

        for (FiguraGeometrica f:figuras) {
            contador++;
            total+= f.area();
        }

        return total/contador;
    }
}
