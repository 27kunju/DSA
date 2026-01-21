package Stream;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class treeSetExample {
    public static void main(String[] args) {
        // Create a Comparator that sorts strings by length
        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        // Create a TreeSet with the custom Comparator
        Set<String> strings = new TreeSet<>(lengthComparator);

        // Add elements to the TreeSet
        strings.add("banana");
        strings.add("apple");
        strings.add("kiwi");
        strings.add("strawberry");

        // Print the TreeSet
        System.out.println(strings); // Output: [kiwi, apple, banana, strawberry]


        /*

          // Create a TreeSet (natural ordering = alphabetical for strings)
        Set<String> strings = new TreeSet<>();

        // Add elements to the TreeSet
        strings.add("banana");
        strings.add("apple");
        strings.add("kiwi");
        strings.add("strawberry");

        // Print the TreeSet
        System.out.println(strings); // Output: [apple, banana, kiwi, strawberry]


        Note:
        TreeSet in Java is a sorted set, implemented as a Red-Black tree.
        When you create a TreeSet without a comparator, it expects elements to implement Comparable.

        String implements Comparable<String> with the compareTo() method.

        So when you do:

        Set<String> strings = new TreeSet<>();
        strings.add("banana");
        strings.add("apple");
        strings.add("kiwi");


           Internally, TreeSet will call compareTo on the strings to decide their position in the tree.
         */
    }
}
