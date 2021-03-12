package com.codepills.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

public class MapSorting {

    public void sortMapByKeys() {

        Map<String, Integer> unsortedMap = new HashMap<>();

        unsortedMap.put("z", 0);
        unsortedMap.put("b", 5);
        unsortedMap.put("a", 6);
        unsortedMap.put("e", 7);
        unsortedMap.put("k", 8);
        unsortedMap.put("f", 9);
        unsortedMap.put("n", 100);
        unsortedMap.put("o", -4);
        unsortedMap.put("m", 2);
        unsortedMap.put("d", 1);

        System.out.println("Unsorted map: ");
        System.out.println(unsortedMap);

        // We need a LinkedHashMap to keep an order of newly returned sorted map.
        Map<String, Integer> result = unsortedMap.entrySet()
                                                 .stream()
                                                 .sorted(Map.Entry.comparingByKey())
                                                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Alternative way
        Map<String, Integer> resultAlternative = new LinkedHashMap<>();
        unsortedMap.entrySet()
                   .stream()
                   .sorted(Map.Entry.comparingByKey())
                   .forEachOrdered(x -> resultAlternative.put(x.getKey(), x.getValue()));

        System.out.println("Sorted map by keys: ");
        System.out.println(result);
        System.out.println(resultAlternative);
    }

    public void sortMapByValues() {

        Map<String, Integer> unsortedMap = new HashMap<>();

        unsortedMap.put("z", 0);
        unsortedMap.put("c", 7);
        unsortedMap.put("q", 4);
        unsortedMap.put("a", 6);
        unsortedMap.put("e", 7);
        unsortedMap.put("k", 8);
        unsortedMap.put("n", 100);
        unsortedMap.put("o", -4);
        unsortedMap.put("m", 2);
        unsortedMap.put("d", 1);

        System.out.println("Unsorted map: ");
        System.out.println(unsortedMap);

        // We need a LinkedHashMap to keep an order of newly returned sorted map.
        Map<String, Integer> result = unsortedMap.entrySet()
                                                 .stream()
                                                 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Alternative way
        Map<String, Integer> resultAlternative = new LinkedHashMap<>();
        unsortedMap.entrySet()
                   .stream()
                   .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                   .forEachOrdered(x -> resultAlternative.put(x.getKey(), x.getValue()));

        System.out.println("Sorted map by values: ");
        System.out.println(result);

        System.out.println("Sorted map by values (alternative approach): ");
        System.out.println(resultAlternative);
    }

    public void sortObjectMap() {

        // Example of the Object map
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();

        System.out.println("Unsorted Object map: ");
        entries.forEach(System.out::println);

        LinkedHashMap<String, String> result = entries.stream()
                                                      .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
                                                      .entrySet()
                                                      .stream()
                                                      .sorted(Map.Entry.comparingByKey())
                                                      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println("Sorted Object map by keys: ");
        result.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}
