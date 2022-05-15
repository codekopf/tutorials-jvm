package com.codepills.flatmap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class FlatteningCollections {

    private FlatteningCollections() {}

    public static final List<List<String>> nestedList = asList(
            asList("1-1", "1-2", "1-3"),
            asList("2-4", "2-5", "2-6", "2-7", "2-8"),
            asList("3-9", "3-10")
    );

    public static final List<Employee> employees = asList(
            new Employee("Mark", Position.JUNIOR_ENGINEER),
            new Employee("Thomas", Position.SENIOR_ENGINEER),
            new Employee("Janet", Position.SOFTWARE_ARCHITECT),
            new Employee("Percy", Position.ENGINEERING_MANAGER)
    );

    public static List<String> flattenListOfLists(final List<List<String>> list) {
        return list.stream()
                   .flatMap(Collection::stream)
                   .collect(Collectors.toList());
    }

    public static List<Position> getAllCareerOptionsAboveJunior(final List<Employee> employees) {
        return employees.stream()
                        .filter(employee -> employee.getPosition().getLevel() > Position.JUNIOR_ENGINEER.getLevel())
                        .map(employee -> createPossibleCareerOptions(employee.getPosition().getLevel()))
                        .flatMap(List::stream) // I need to flatten list streams into one stream
                        .collect(Collectors.toList());
    }

    public static List<Position> createPossibleCareerOptions(int level) {
        return Arrays.stream(Position.values())
                     .filter(position -> position.getLevel() > level)
                     .collect(Collectors.toList());
    }

}
