package org.isayan.library.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNameGenerator {

    private static final List<String> FIRST_NAMES = Arrays.asList(
            "Alice", "Bob", "Charlie", "Diana", "Ethan",
            "Fiona", "George", "Hannah", "Ian", "Julia"
    );

    private static final List<String> LAST_NAMES = Arrays.asList(
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"
    );

    private final Random random;

    public RandomNameGenerator() {
        this.random = new Random();
    }

    /** Returns a random first name */
    public String randomFirstName() {
        return FIRST_NAMES.get(random.nextInt(FIRST_NAMES.size()));
    }

    /** Returns a random last name */
    public String randomLastName() {
        return LAST_NAMES.get(random.nextInt(LAST_NAMES.size()));
    }

    /** Returns a random full name */
    public String randomFullName() {
        return randomFirstName() + " " + randomLastName();
    }
}
