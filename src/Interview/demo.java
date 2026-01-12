package Interview;


class Person {
    Person(String name) {
        System.out.println("Person name: " + name);
    }
}

class Employee extends Person {
    Employee(String name, int id) {
        super(name); // Calls parent constructor
        System.out.println("Employee ID: " + id);
    }
}


public class demo {
}
