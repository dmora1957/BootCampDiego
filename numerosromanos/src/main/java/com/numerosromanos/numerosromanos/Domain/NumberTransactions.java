package com.numerosromanos.numerosromanos.Domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NumberTransactions {
    private TreeMap<Integer, String> map;

    public NumberTransactions()
    {
        map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public String integerToRoman(int integerNumber)
    {
        int l =  map.floorKey(integerNumber);
        if ( integerNumber == l ) {
            return map.get(integerNumber);
        }
        return map.get(l) + integerToRoman(integerNumber-l);
    }
}
