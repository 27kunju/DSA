package Interview;

class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}

public class ExceptionDemo {
    static void test() throws MyCheckedException {
        throw new MyCheckedException("Checked");
    }

    public static void main(String[] args) {
        // Must handle or declare
        try {
            test();
        } catch (MyCheckedException e) {
            System.out.println("Handled checked");
        }
    }
}
