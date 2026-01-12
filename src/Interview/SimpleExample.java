package Interview;

class Car{
    private String model;

}

public class SimpleExample {

    public static void main(String[] args) {
        a();
    }

    public static void a() {
        int x = 1;
        b();
    }

    public static void b() {
        Car y = new Car();
        c();
    }

    public static void c() {
        float z = 2.11f;
    }
}


/*


Eden -> Minor GC -> Survivor S0 (age++) -> Survivor S1 (age++)
Age threshold reached -> Old Generation

 */
