package Interview;

class Address {
    String city;
    Address(String city) { this.city = city; }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Delhi");
        Person p1 = new Person("Ashwini", addr);
        Person p2 = (Person) p1.clone();

        p2.name = "Rohit";
        p2.address.city = "Mumbai";

        System.out.println(p1.address.city); // prints "Mumbai" ❌ (shared reference)
    }
}
