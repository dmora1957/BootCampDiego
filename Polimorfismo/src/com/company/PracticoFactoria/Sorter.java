package com.company.PracticoFactoria;

import java.util.Comparator;

public interface Sorter <T> {
    boolean sort(T arr[], Comparator<T> c);
}
