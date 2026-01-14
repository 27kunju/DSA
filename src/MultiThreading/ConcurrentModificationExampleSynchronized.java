package MultiThreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class ConcurrentModificationExampleSynchronized {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Thread 1: Iterating and removing elements with proper synchronization
        Thread thread1 = new Thread(() -> {
            synchronized (numbers) {
                Iterator<Integer> iterator = numbers.iterator();
                while (iterator.hasNext()) {
                    Integer number = iterator.next();
                    System.out.println("Thread 1::value=>"+number);

                }
            }
        });

        // Thread 2: Adding an element to the list concurrently
        Thread thread2 = new Thread(() -> {
            synchronized (numbers) {
                numbers.add(4);

            }
        });

        thread1.start();
        thread2.start();

        System.out.println("List after modification: " + numbers);
    }

    public void usingCollectionSSynchronized() throws InterruptedException {

        List<Integer> numbers =
                Collections.synchronizedList(new ArrayList<>());

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Thread 1: Iteration (must synchronize explicitly)
        Thread thread1 = new Thread(() -> {
            synchronized (numbers) {
                Iterator<Integer> iterator = numbers.iterator();
                while (iterator.hasNext()) {
                    Integer number = iterator.next();
                    System.out.println("Thread 1::value => " + number);
                }
            }
        });

        // Thread 2: Modification (already synchronized internally)
        Thread thread2 = new Thread(() -> {
            numbers.add(4); // thread-safe
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("List after modification: " + numbers);
    }


    /*


    Collections.synchronizedList synchronizes individual method calls, not compound operations like iteration.
Iteration must still be manually synchronized to prevent concurrent modification.

What Collections.synchronizedList actually guarantees

When you do:

List<Integer> list =
    Collections.synchronizedList(new ArrayList<>());


Java internally does:

public E get(int index) {
    synchronized (mutex) {
        return list.get(index);
    }
}


✔ add() → synchronized
✔ remove() → synchronized
✔ get() → synchronized

But ❌ iteration is NOT a single method call.
     */
}
/*Output:
Thread 1::value=>1
Thread 1::value=>2
Thread 1::value=>3
List after modification: [1, 2, 3, 4]
*/