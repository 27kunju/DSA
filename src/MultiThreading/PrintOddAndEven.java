package MultiThreading;

public class PrintOddAndEven {

    // true  -> odd thread's turn
    // false -> even thread's turn
    private static boolean isOddTurn = true;

    // Common lock shared by both threads
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Runnable oddTask = () -> {
            for (int i = 1; i <= 100; i += 2) {

                synchronized (lock) {

                    // Wait until it is odd thread's turn
                    while (!isOddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    // Print odd number
                    System.out.println("Odd  : " + i);

                    // Switch turn to even thread
                    isOddTurn = false;

                    // Wake up waiting threads
                    lock.notifyAll();
                }
            }
        };

        Runnable evenTask = () -> {
            for (int i = 2; i <= 100; i += 2) {

                synchronized (lock) {

                    // Wait until it is even thread's turn
                    while (isOddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    // Print even number
                    System.out.println("Even : " + i);

                    // Switch turn to odd thread
                    isOddTurn = true;

                    // Wake up waiting threads
                    lock.notifyAll();
                }
            }
        };

        Thread oddThread = new Thread(oddTask);
        Thread evenThread = new Thread(evenTask);

        oddThread.start();
        evenThread.start();
    }
}
