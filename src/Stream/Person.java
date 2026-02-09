package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Person {

    private final String name;
    private final int age;
    private final List<String> hobbies;

    // Constructor
    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        // Defensive copy to maintain immutability
        this.hobbies = new ArrayList<>(hobbies);
    }

    // Getters (return defensive copy for mutable fields)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);
    }

    // Override equals for logical equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;          // Same reference
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(hobbies, person.hobbies);
    }

    // Override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, age, hobbies);
    }
}
