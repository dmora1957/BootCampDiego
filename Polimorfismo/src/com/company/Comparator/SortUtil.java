package com.company.Comparator;

import java.util.Comparator;

public class SortUtil {
    public static <T> void ordenar(T arr[], Comparator comp)
    {
       /* for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1].precedeA(arr[j])) {
                    intecambiar(arr, j, j+1);
                }
            }
        }*/
    }
    public static void intecambiar(Precedable arr[], int a, int b) {
        var value = arr[b];
        arr[b] = arr[a];
        arr[a] = value;
    }
}
