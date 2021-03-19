package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContarNPrimos();
    }


    public static void ContarPares()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de n pares");
        int n = scanner.nextInt();
        int cont = 0;
        int num =1;
        while(cont <= n)
        {
            if(num % 2 == 0)
            {
               cont++;
               System.out.println(num);
            }
            num++;
        }
    }

    public static void ContarMultiplo()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de multiplo");
        int n = scanner.nextInt();

        System.out.println("Ingrese el num");
        int m = scanner.nextInt();

        int cont = 0;
        int num =1;
        while(cont <= n || num <= m)
        {
            if(num % m == 0)
            {
                cont++;
                System.out.println(num);
            }
            num++;
        }
    }

    public static void EsPrimo()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero");
        int n = scanner.nextInt();

        boolean esPrimo = EsPrimo(n);

        System.out.println(n + " es " + (esPrimo ? "Primo" : " no es primo"));
    }

    public static boolean EsPrimo(int n)
    {
        int divisor =2;
        boolean esPrimo = true;

        while( divisor < n && esPrimo)
        {
            if(n % divisor == 0)
            {
                esPrimo = false;
            }
            divisor++;
        }

       return esPrimo;
    }

    public static void ContarNPrimos()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los primero n primos");
        int n = scanner.nextInt();

        int contador =0;
        int num =1;

        while( contador < n )
        {
            if(EsPrimo(num))
            {
                System.out.println(num + " es Primo");
                contador++;
            }
            num++;
        }
    }

    public static void NumerosNaturales() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese cantidad de apariciones");
        int apariciones = scanner.nextInt();

        System.out.println("Ingrese los primero n numeros");
        int primerosN = scanner.nextInt();

        System.out.println("Ingrese el num");
        int digito = scanner.nextInt();

        int num = digito;

        for (int i = 0; i < apariciones; i++) {
            num *= 10;
            num += digito;
        }

    }
        public void ej5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros a buscar(n):");
        int n = scanner.nextInt();

        System.out.println("Ingrese la cantidad de digitos(m):");
        int m = scanner.nextInt();

        System.out.println("Ingrese el digito(d):");
        int d = scanner.nextInt();

        int i = 0;
        int j = 0;
            while (i < n) {
                ArrayList<Integer> digitos = separarDigitos(j);
                int cantDigitos = contarDigitos(digitos, d);
                if (cantDigitos == m) {
                    System.out.println(j);
                    i++;
                }
                j++;
            }
        }

    public ArrayList<Integer> separarDigitos(int numero){
        ArrayList<Integer> digitos = new ArrayList<Integer>();
        while (numero>0){
            digitos.add(numero%10);
            numero = numero/10;
        }
        return digitos;

    }
    public int contarDigitos(ArrayList<Integer> digitos, int aContar){
        int count = 0;
        for(int digito:digitos){
            if(digito==aContar){
                count++;
            }
        }
        return count;
    }
}
