package com.codepills;

import com.codepills.comparator.ComparatorExamples;
import com.codepills.map.MapSorting;

public class Main {
    public static void main(String[] argv) {
        MapSorting mapSorting = new MapSorting();
        mapSorting.sortMapByKeys();
        mapSorting.sortMapByValues();
        mapSorting.sortObjectMap();

        ComparatorExamples.comparingInt();
    }
}
