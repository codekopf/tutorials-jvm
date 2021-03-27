package com.codepills.conversion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapToArray {

    public static void main (String[] args)
    {
        entrySetToArray();
        keySetToArray();
        valuesCollectionToArray();
        useLinkedHashMapElementOrderForArrayConversion();
        maintainKeySetAndValueCollectionArray();
    }

    // Method to convert Map entry set into an Array in Java
    public static void entrySetToArray()
    {
        final Map<String, String> map = new HashMap<>();

        map.put("John Doe", "555-869-759");
        map.put("Thomas Cook", "555-906-941");
        map.put("Paul Smith", "555-400-321");

        // Gets the Map entry set and turns it into an Array of Objects
        final Object[] objectArray = map.entrySet().toArray();

        System.out.println(Arrays.toString(objectArray));
    }

    // Method to convert Map keys into an Array in Java
    public static void keySetToArray()
    {
        final Map<String, String> map = new HashMap<>();

        map.put("John Doe", "555-869-759");
        map.put("Thomas Cook", "555-906-941");
        map.put("Paul Smith", "555-400-321");

        // Gets the Map set of keys which is turned to an Array of Strings
        String[] keys = map.keySet().toArray(new String[0]);

        System.out.println(Arrays.toString(keys));
    }

    // Method to convert Map values into an Array in Java
    public static void valuesCollectionToArray()
    {
        final Map<String, String> map = new HashMap<>();

        map.put("John Doe", "555-869-759");
        map.put("Thomas Cook", "555-906-941");
        map.put("Paul Smith", "555-400-321");

        // Gets the Map collection of values and turn it into the Array of Strings
        String[] values = map.values().toArray(new String[0]);

        System.out.println(Arrays.toString(values));
    }

    // Method to convert Map elements to an Array in Java
    // However, the core of this method lies in the Map's implementation LinkedHashMap
    // which maintains the order of inserted elements in the order of their insertion.
    public static void useLinkedHashMapElementOrderForArrayConversion()
    {
        final Map<String, String> map = new LinkedHashMap<>();

        map.put("John Doe", "555-869-759");
        map.put("Thomas Cook", "555-906-941");
        map.put("Paul Smith", "555-400-321");

        // Get an array of keys in order of the LinkedHashMap
        final String[] keys = map.keySet().toArray(new String[0]);

        // Get an array of values in order of the LinkedHashMap
        final String[] values = map.values().toArray(new String[0]);

        for (int i = 0; i < map.size(); i++) {
            System.out.println( "[ " + keys[i] + " = " + values[i] + " ]" );
        }
    }

    // Method to convert Map to an Array in Java
    public static void maintainKeySetAndValueCollectionArray()
    {
        final Map<String, String> map = new HashMap<>();

        map.put("John Doe", "555-869-759");
        map.put("Thomas Cook", "555-906-941");
        map.put("Paul Smith", "555-400-321");

        // Temporary array to store map keys
        final String[] keys = new String[map.size()];

        // Temporary array to store map values
        final String[] values = new String[map.size()];

        int i = 0;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            keys[i] = entry.getKey();
            values[i] = entry.getValue();
            i++;
        }

        for (i = 0; i < map.size(); i++) {
            System.out.println( "[ " + keys[i] + " = " + values[i] + " ]" );
        }
    }

}
