package Stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImmutableExample {
    public static void main(String[] args) {
        List<String> hobbies1 = List.of("dancing");
        Person p1 = new Person("Ashwini", 25, hobbies1);
        Person p2 = new Person("Ashwini", 25, hobbies1);

        System.out.println("p1 == p2? " + (p1 == p2));          // false, different objects
        System.out.println("p1.equals(p2)? " + p1.equals(p2));  // true, same state

        // Try modifying original list
//         hobbies1.add("singing"); // This will throw error because List.of is immutable

        // Check that internal state is still safe
        System.out.println("p1 hobbies: " + p1.getHobbies());
        System.out.println("p2 hobbies: " + p2.getHobbies());

        // Even if we try to modify the getter list
        List<String> externalHobbies = p1.getHobbies();
        externalHobbies.add("singing"); // modifies external list only

        System.out.println("p1 hobbies after external change: " + p1.getHobbies()); // still unchanged
    }
}
