package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeOperation {
    public static void main(String[] args) {
        Department d1 = new Department(1L, "IT");
        Department d2 = new Department(2L, "HR");
        Department d3 = new Department(3L, "RD");
        List<String> skills = List.of("Java", "Javascript", "DSA", "Springboot");
        List<String> skills2 = List.of("React", "Javascript");
        List<String> skills3 = List.of("Communication");
        Employee em1 = new Employee(1L, "Ashwini", 25000.0, d1, skills);
        Employee em2 = new Employee(2L, "Gokul", 30000.0, d1, skills);
        Employee em3 = new Employee(3L, "Ammu", 10000.0, d3,skills3);
        Employee em4 = new Employee(5L, "kavya", 20000.0 , d3, skills3);
        Employee em5 = new Employee(4L,"Tanu", 40000.0, d2, skills2);
        Employee em6 = new Employee(5L, "Madhu", 25000.0, d2, skills2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(em1);
        employeeList.add(em2);
        employeeList.add(em3);
        employeeList.add(em4);
        employeeList.add(em5);
        employeeList.add(em6);

        //Average salary
        Map<String, Double> avrSalary = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment().getName(), Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avrSalary + " ");

        //sort on salary
        List<Employee> sortedSalary = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
        System.out.println(sortedSalary + " ");

        //get unique skills
        List<String> uniqueSkills = employeeList.stream().flatMap(e -> e.getSkills().stream()).distinct().sorted().toList();
        System.out.println(uniqueSkills + " ");

        //highest salary by each dept
        Map<String, Optional<Employee>> highestSalaryByDept = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment().getName(), Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(highestSalaryByDept + " ");

        //mapping each skill to employee names
        Map<String , List<String>> skillwithNames = employeeList.stream()
                .flatMap(e -> e.getSkills().stream()
                        .map( skill -> Map.entry(skill, e.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        System.out.println(skillwithNames+ " ");

        //mapping each skills on dept wise
        Map<String, Set<String>> mapSkills = employeeList.stream()
                .flatMap(emp -> emp.getSkills().stream()
                        .map(skill -> Map.entry(emp.getDepartment().getName(), skill)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,                                // department name
                        Collectors.mapping(Map.Entry::getValue,            // skill
                                Collectors.toSet())             // collect as Set
                ));
        System.out.println(mapSkills);

    }
}
