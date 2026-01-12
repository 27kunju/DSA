package Stream;

import java.util.*;
import java.util.stream.Collectors;

class EmployeeDemo implements Comparable<EmployeeDemo> {
    String name;
    double salary;
    int id;

    EmployeeDemo(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    // Comparable - natural ordering by salary
    @Override
    public int compareTo(EmployeeDemo o) {
        return Double.compare(this.salary, o.salary); // ascending salary
    }

    @Override
    public String toString() {
        return name + " [ID:" + id + ", Salary:" + salary + "]";
    }

    // Getter for Comparator examples
    public double getSalary() { return salary; }
    public String getName() { return name; }
    public int getId() { return id; }
}

public class SortingDemo {
    public static void main(String[] args) {

        List<EmployeeDemo> employees = new ArrayList<>();
        employees.add(new EmployeeDemo("Alice", 5000, 101));
        employees.add(new EmployeeDemo("Bob", 3000, 103));
        employees.add(new EmployeeDemo("Charlie", 4000, 102));
        employees.add(new EmployeeDemo("David", 3000, 104));

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        // -------------------------------
        // 1️⃣ Comparable - Natural order (salary ascending)
        // -------------------------------
        Collections.sort(employees); // uses compareTo()
        System.out.println("\nSorted by salary (Comparable - natural order):");
        employees.forEach(System.out::println);

        // -------------------------------
        // 2️⃣ Comparator - Sort by name
        // -------------------------------
        employees.sort(Comparator.comparing(EmployeeDemo::getName));
        System.out.println("\nSorted by name (Comparator):");
        employees.forEach(System.out::println);

        // -------------------------------
        // 3️⃣ Comparator - Sort by salary descending
        // -------------------------------
        employees.sort(Comparator.comparingDouble(EmployeeDemo::getSalary).reversed());
        System.out.println("\nSorted by salary descending (Comparator):");
        employees.forEach(System.out::println);

        // -------------------------------
        // 4️⃣ Comparator - Multi-level sorting: salary ascending, then name
        // -------------------------------
        employees.sort(
                Comparator.comparingDouble(EmployeeDemo::getSalary)
                        .thenComparing(EmployeeDemo::getName)
        );
        System.out.println("\nSorted by salary ascending, then name (Comparator chaining):");
        employees.forEach(System.out::println);

        // -------------------------------
        // 5️⃣ Stream.sorted() with Comparator
        // -------------------------------
        List<EmployeeDemo> sortedStream = employees.stream()
                .sorted(Comparator.comparingInt(EmployeeDemo::getId))
                .collect(Collectors.toList());

        System.out.println("\nSorted by ID using Stream.sorted():");
        sortedStream.forEach(System.out::println);

        // -------------------------------
        // 6️⃣ Sorting array of primitives
        // -------------------------------
        int[] nums = {5, 2, 8, 1};
        Arrays.sort(nums);
        System.out.println("\nSorted int array: " + Arrays.toString(nums));

        // Descending order for Integer array using Comparator
        Integer[] numsBoxed = {5, 2, 8, 1};
        Arrays.sort(numsBoxed, (a, b) -> b - a);
        System.out.println("Sorted Integer array descending: " + Arrays.toString(numsBoxed));
    }
}

