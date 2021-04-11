package com.codepills;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class JavaBasicsTest {

    @Test
    public void testJUnitListAsserts() {
        final List<String> users = Arrays.asList("John Doe", "Tom Smith", "Paul Iron", "George Silver");
        final List<String> moderators = Arrays.asList("John Doe", "Tom Smith", "Paul Iron", "George Silver");
        final List<String> admins = Arrays.asList("John Doe", "Tom Smith", "Paul Iron", "Georg Silver");

        System.out.println("Lists are equal? " + compareLists(users, moderators));

        Assert.assertEquals(users, moderators);
        Assert.assertNotSame(users, moderators);
        Assert.assertNotEquals(users, admins);
    }

    private boolean compareLists(final List list1,final List list2) {
        return list1.equals(list2);
    }
}
