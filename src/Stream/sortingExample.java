package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class sortingExample {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5,3,6,7,2);


        //sort in decending order
        List<Integer> decNums = nums.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(decNums);


        Department d1 = new Department(1L, "IT");
        Department d2 = new Department(2L, "HR");
        Department d3 = new Department(3L, "RD");
        List<String> skills = List.of("Java", "Javascript", "DSA", "Springboot");
        List<String> skills2 = List.of("React", "Javascript");
        List<String> skills3 = List.of("Communication");
        Employee em1 = new Employee(1L, "Ashwini", 25000.0, d1, skills,27);
        Employee em2 = new Employee(2L, "Gokul", 30000.0, d1, skills,27);
        Employee em3 = new Employee(3L, "Ammu", 10000.0, d3,skills3,20);
        Employee em4 = new Employee(5L, "kavya", 20000.0 , d3, skills3,28);
        Employee em5 = new Employee(4L,"Tanu", 40000.0, d2, skills2,28);
        Employee em6 = new Employee(5L, "Madhu", 25000.0, d2, skills2,28);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(em1);
        employeeList.add(em2);
        employeeList.add(em3);
        employeeList.add(em4);
        employeeList.add(em5);
        employeeList.add(em6);

        Comparator<Employee> comp =
                Comparator.comparing(Employee::getSalary)
                        .thenComparingInt(Employee::getAge);


        //we can use reversed() method when already comparator is present
        List<Employee> result = employeeList.stream()
                .sorted(comp.reversed())
                .toList();

    }
}
