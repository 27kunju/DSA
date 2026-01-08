package MultiThreading;

public class VolatileExample {
    private static volatile boolean flag = false;

    /*
    What is volatile?

volatile ensures visibility of a variable across threads.

When a variable is marked volatile:

Every write goes directly to main memory

Every read comes directly from main memory

It prevents caching of the variable in thread-local CPU caches.

Why volatile is REQUIRED here
while (!flag) {
    // no println
    // no synchronization
}


The reader thread is in a busy-wait loop

Without volatile, the reader thread may:

Cache flag = false

Never re-read from main memory

Loop forever

With volatile:

Writer thread updates flag = true

Change is immediately visible to reader thread

Loop exits correctly
     */

    public static void main(String[] args) {

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) { }

            flag = true;
            System.out.println("Flag set to true");
        });

        Thread reader = new Thread(() -> {
            while (!flag) {
                // NO println, NO synchronization

                /*
                Why while (!flag) { System.out.println(...) } works without volatile

Although flag is not declared as volatile, the code still works because
System.out.println() is internally synchronized.

What happens internally:

println() acquires and releases a monitor lock

Lock acquisition & release create a happens-before relationship

This forces:

CPU cache flush

Read of the latest value from main memory

As a result, the reader thread eventually sees flag = true, even without volatile.

Key point:

This visibility is accidental, caused by synchronization inside println(),
not because the variable is safely published.
                 */
            }
            System.out.println("Flag observed as true");
        });

        writer.start();
        reader.start();
    }
}
