package Stream;

class Address implements Cloneable {
    String city;

    Address(String city) {
        this.city = city;
    }

    // Override clone for deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy for Address itself
    }
}

class EmployeeClone implements Cloneable {
    String name;
    Address address;

    EmployeeClone(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy
    protected Object shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep copy
    protected EmployeeClone deepClone() throws CloneNotSupportedException {
        EmployeeClone cloned = (EmployeeClone) super.clone(); // clone top-level object
        cloned.address = (Address) address.clone(); // clone nested object
        return cloned;
    }
}

public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("New York");
        EmployeeClone emp1 = new EmployeeClone("Alice", addr);

        // Shallow Copy
        EmployeeClone empShallow = (EmployeeClone) emp1.shallowClone();
        empShallow.address.city = "Los Angeles"; // change nested object

        System.out.println("Shallow Copy:");
        System.out.println("Original Employee Address: " + emp1.address.city); // Los Angeles
        System.out.println("Shallow Clone Address: " + empShallow.address.city); // Los Angeles

        // Reset original address
        emp1.address.city = "New York";

        // Deep Copy
        EmployeeClone empDeep = emp1.deepClone();
        empDeep.address.city = "Chicago"; // change nested object

        System.out.println("\nDeep Copy:");
        System.out.println("Original Employee Address: " + emp1.address.city); // New York
        System.out.println("Deep Clone Address: " + empDeep.address.city);

        // Chicago


    }
}
