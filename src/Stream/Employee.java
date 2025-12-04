package Stream;

import java.util.List;
import java.util.Objects;

public class Employee {

    private Long id;

    private String name;

    private Double salary;

    private int age;

    private List<String> skills;

    private Department department;

    public Employee(Long id , String name , Double salary, Department department, List<String> skills, int age){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.skills = skills;
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department=" + department +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name)
                && Objects.equals(salary, employee.salary)
                && Objects.equals(skills, employee.skills)
                && Objects.equals(department, employee.department)
                && Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, skills, department,age);
    }
}
