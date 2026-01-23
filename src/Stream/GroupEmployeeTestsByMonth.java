package Stream;

import java.time.LocalDate;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

class EmployeeTest {
    private int id;
    private String name;
    private String lastName;
    private LocalDate joiningDate;

    public EmployeeTest(int id, String name, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // For readable output
    @Override
    public String toString() {
        return name + " (" + joiningDate + ")";
    }
}

public class GroupEmployeeTestsByMonth {

    public static void main(String[] args) {

        List<EmployeeTest> EmployeeTests = List.of(
                new EmployeeTest(1, "Ashwini", LocalDate.of(2022, 1, 15)),
                new EmployeeTest(2, "Ravi",     LocalDate.of(2022, 1, 20)),
                new EmployeeTest(3, "Neha",     LocalDate.of(2022, 3, 10)),
                new EmployeeTest(4, "Kiran",    LocalDate.of(2022, 3, 25)),
                new EmployeeTest(5, "Anita",    LocalDate.of(2022, 5, 5))
        );

        // 🔹 Grouping by month of joining
        Map<Month, List<EmployeeTest>> EmployeeTestsByMonth =
                EmployeeTests.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getJoiningDate().getMonth()
                        ));

        // 🔹 Printing result
        EmployeeTestsByMonth.forEach((month, empList) -> {
            System.out.println(month + " : " + empList);
        });

        Map<Month, Long> countByMonth =
                EmployeeTests.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getJoiningDate().getMonth(),
                                Collectors.counting()
                        ));
        System.out.println(countByMonth);

        String lastName = "Dey";

        List<EmployeeTest> result =
                EmployeeTests.stream()
                        .filter(e -> lastName.equals(e.getLastName()))
                        .sorted(Comparator.comparing(EmployeeTest::getJoiningDate))
                        .toList();

        // Remove duplicates based on name
        List<EmployeeTest> distinctEmployees =
                new ArrayList<>(new LinkedHashSet<>(EmployeeTests));

        distinctEmployees.forEach(System.out::println);

    }


}

