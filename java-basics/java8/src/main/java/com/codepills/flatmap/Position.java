package com.codepills.flatmap;

public enum Position {

    JUNIOR_ENGINEER(1),
    SENIOR_ENGINEER(2),
    SOFTWARE_ARCHITECT(3),
    ENGINEERING_MANAGER(4);

    private final int level;

    Position(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}
