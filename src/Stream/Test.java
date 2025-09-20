package Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Employee2 {
    private int id;
    private String name;

    Employee2(int id, String name) {
        this.id = id;
        this.name = name;
    }



    // Only equals() overridden, not hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return id == e.getId() && name.equals(e.getName());
    }
}

public class Test {
    public static void main(String[] args) {
        Employee2 e1 = new Employee2(1, "John");
        Employee2 e2 = new Employee2(1, "John");

        HashMap<Employee2, String> map = new HashMap<>();
        map.put(e1, "Developer");
        map.put(e2, "Manager"); // Expected: update same key, Actual: adds new key

        System.out.println(map.size()); // Output: 2 (Unexpected!)


    }
}

