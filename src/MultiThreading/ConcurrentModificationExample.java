package MultiThreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExample{
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Thread 1: Iterating and modifying the list
        Thread thread1 = new Thread(() -> {
            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                System.out.println("Thread 1::value=>"+number);

            }
        });

        // Thread 2: Adding an element to the list concurrently
        Thread thread2 = new Thread(() -> {
            try {
                numbers.add(4);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();


        System.out.println("List after modification: " + numbers);
    }
}

/*
Output:
Exception in thread "Thread-0" java.util.ConcurrentModificationException
    at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1043)
    at java.base/java.util.ArrayList$Itr.next(ArrayList.java:997)
    at ConcurrentModificationExample.lambda$main$0(ConcurrentModificationExample.java:16)
    at java.base/java.lang.Thread.run(Thread.java:829)
*/
