package Stream;

import java.util.List;

public class Employee {

    private Long id;

    private String name;

    private Double salary;

    private List<String> skills;

    private Department department;

    public Employee(Long id , String name , Double salary, Department department, List<String> skills){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.skills = skills;
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
}
