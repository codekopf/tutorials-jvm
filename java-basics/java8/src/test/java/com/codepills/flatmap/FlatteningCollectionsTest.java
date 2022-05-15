package com.codepills.flatmap;

import java.util.List;

import org.junit.Test;

import static com.codepills.flatmap.FlatteningCollections.flattenListOfLists;
import static com.codepills.flatmap.FlatteningCollections.getAllCareerOptionsAboveJunior;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class FlatteningCollectionsTest {

    private final List<List<String>> nestedList = FlatteningCollections.nestedList;
    private final List<Employee> employees = FlatteningCollections.employees;

    @Test
    public void testFlatteningTheListOfLists_simpleScenario() {
        List<String> flattenedList = flattenListOfLists(nestedList);

        assertNotNull(flattenedList);
        assertEquals(10, flattenedList.size());

        for (String element : flattenedList) {
            System.out.print(element + ", ");
        }
    }

    @Test
    public void testFlatteningTheListOfLists_realisticScenario() {
        List<Position> allPossiblePromotions = getAllCareerOptionsAboveJunior(employees);

        assertNotNull(allPossiblePromotions);
        assertEquals(3, allPossiblePromotions.size());

        for (Position position : allPossiblePromotions) {
            System.out.print(position + ", ");
        }
    }

}
