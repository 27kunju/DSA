package MultiThreading;


public class StackOverflowExample {
        public static void recursiveMethod() {
            // No base case → infinite recursion
            recursiveMethod();
        }

        public static void main(String[] args) {
            try {
                recursiveMethod();
            } catch (StackOverflowError e) {
                System.out.println("StackOverflowError caught! " + e);
            }
            System.out.println("Program continues safely.");
        }
    }

