package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student1 {
    String name;
    int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Custom equals() and hashCode() to treat students with same name & age as the same object
    @Override
    public boolean equals(Object obj) {
        // if (this == obj) return true;
        // if (obj == null || getClass() != obj.getClass()) return false;
        Student1 student1 = (Student1) obj;
        return age == student1.age && Objects.equals(name, student1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }
}

public class StudentFrequency {
    public static void main(String[] args) {
        // Sample Input: List of Students
        List<Student1> students = Arrays.asList(
                new Student1("Ashok", 11),
                new Student1("Ram", 12),
                new Student1("Ashok", 11),
                new Student1("Ram", 12),
                new Student1("Dilip", 23),
                new Student1("Dilip", 20)
        );

        // Count frequency of each student using Collectors.groupingBy()
        Map<Student1, Long> frequencyMap = students.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the frequency of each student
        frequencyMap.forEach((student, count) ->
                System.out.println("Frequency of student " + student + " is: " + count)
        );
    }
}
