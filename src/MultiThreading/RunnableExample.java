package MultiThreading;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Task running");
        };

        new Thread(task).start();

    }
}
