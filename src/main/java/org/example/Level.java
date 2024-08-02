package org.example;

import java.util.Arrays;

public enum Level {
    EASY(1,10),
    STANDARD(2,8),
    HARD(3,6),
    EXTREME(4,5);

    private int choice;
    private int chance;

    public int getChoice() {
        return choice;
    }

    Level(int choice, int chance) {
        this.choice = choice;
        this.chance = chance;
    }

    public int getChance() {
        return this.chance;
    }

    public static int findChance(int choice) {
        return Arrays.stream(Level.values())
                .filter(level -> level.getChoice() == choice)
                .findAny()
                .orElse(EASY)
                .getChance();
    }

}
