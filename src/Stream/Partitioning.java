package Stream;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    String name; int marks;
    Student(String name, int marks) {
        this.name = name; this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Partitioning {
    public static void main(String[] args) {

        /*
         Partitioning in Java Streams splits elements into two groups based on a predicate,
          returning a Map<Boolean, List<T>> — true for elements matching the condition,
          false for others. It’s useful for things like separating even/odd numbers, passed/failed students, or adults/minors.
          Essentially, it’s a special case of groupingBy that always creates only two groups
         */

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitioned);
        // Output: {false=[1, 3, 5], true=[2, 4, 6]}

        List<Student> students = List.of(
                new Student("Alice", 80),
                new Student("Bob", 45),
                new Student("Charlie", 60)
        );

        Map<Boolean, List<Student>> result = students.stream()
                .collect(Collectors.partitioningBy(s -> s.marks >= 50));

        System.out.println(result.get(true).stream().map(s -> s.name).toList()); // Passed: [Alice, Charlie]
        System.out.println(result.get(false).stream().map(s -> s.name).toList()); // Failed: [Bob]

        Map<String, Integer> passedMap = result.get(true).stream()
                .collect(Collectors.toMap(s -> s.name, s -> s.marks));

        Map<String, Integer> failedMap = result.get(false).stream()
                .collect(Collectors.toMap(s -> s.name, s -> s.marks));

        System.out.println(result);
        System.out.println(failedMap);




    }
}
