package Stream;

public class TryCatch {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            int result = 10 / 0; // no exception
            System.out.println("Result = " + result);
        } finally {
            System.out.println("Finally block always executes");
        }
        System.out.println("Program continues...");
    }

}
