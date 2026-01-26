package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerPractice {

    private static final Queue<Integer> buffer = new LinkedList<>();
    private static final int MAXSIZE = 5;

    public static void main(String[] args) {

        Runnable producer = () -> {
            for (int i = 0; i < 10; i++) {
                synchronized (buffer) {
                    while (buffer.size() == MAXSIZE) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    buffer.add(i);
                    System.out.println("Produced: " + i);

                    /*
                    Why notifyAll() instead of notify()?
                    Because with multiple producers and consumers, notify()
                     may wake up the wrong type of thread,causing threads to block forever
                     */
                    buffer.notifyAll();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 10; i++) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    int val = buffer.remove();
                    System.out.println("Consumed: " + val);
                    buffer.notifyAll();
                }
            }
        };

        Thread t1 = new Thread(producer, "Producer");
        Thread t2 = new Thread(consumer, "Consumer");

        t1.start();
        t2.start();
    }
}
