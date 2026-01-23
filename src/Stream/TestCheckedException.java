package Stream;

import java.io.IOException;

public class TestCheckedException {


    // checked exception must be handled using try catch block

        static void method1() throws IOException {
            throw new IOException("File not found");
        }

        static void method2() throws IOException {
            method1();
        }

        public static void main(String[] args) throws IOException {
            method2();
            System.out.println("End of program");
        }

}
