package Stream;

public class staticExample {
    static int x = 10;
    public static void main(String[] args) {
        // static int a = 10;

        /*

        In Java, static variables belong to the class, not an instance or method.
         Local variables inside a method are created on the stack every time the method runs,
         whereas static variables live in the method area / class memory and exist for the entire lifetime of the program.
         Therefore, Java does not allow static local variables because it would conflict with their lifetime and memory management.
         */


         System.out.println(x);

    }


}
