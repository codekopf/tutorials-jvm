package com.codepills.flatmap;

public class Employee {

    private final String name;
    private final Position position;

    public Employee(final String name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
