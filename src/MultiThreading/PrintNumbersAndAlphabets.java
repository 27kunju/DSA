package MultiThreading;

/*
 * Goal:
 * Print output in the sequence:
 * A 1 B 2 C 3 ... Z 26
 *
 * Concept Used:
 * - Multiple threads
 * - Shared resource
 * - Context switching
 * - wait() / notify() for thread coordination
 *
 * Important:
 * Context switching means the OS pauses one thread
 * and allows another thread to execute.
 * This is NOT thread interruption.
 */

public class PrintNumbersAndAlphabets {

    /*
     * Shared flag used by both threads
     * true  -> Letter thread should print
     * false -> Number thread should print
     */
    private static boolean printLetter = true;

    /*
     * Common lock object (monitor)
     * Both threads synchronize on the SAME lock
     */
    private static final Object lock = new Object();

    public static void main(String[] args){

        /*
         * Letter printing task
         * Prints A to Z
         */
        Runnable letterTask = new Runnable(){
            @Override
            public void run() {

                // Loop through characters A to Z
                for(char ch = 'A'; ch <= 'Z'; ch++){

                    // Enter synchronized block using shared lock
                    synchronized (lock){

                        /*
                         * If it is NOT letter's turn,
                         * release the lock and wait.
                         * Thread enters WAITING state.
                         */
                        if(!printLetter){
                            try {
                                lock.wait(); // releases lock and waits
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        // Critical section: printing letter
                        System.out.println(ch);

                        // Change turn to number thread
                        printLetter = false;

                        // Wake up waiting thread (number thread)
                        lock.notify();
                    }
                }
            }
        };

        /*
         * Number printing task
         * Prints 1 to 26
         */
        Runnable numberTask = new Runnable(){
            @Override
            public void run() {

                // Loop through numbers 1 to 26
                for(int i = 1; i <= 26; i++){

                    // Enter synchronized block using shared lock
                    synchronized (lock){

                        /*
                         * If it IS letter's turn,
                         * release the lock and wait.
                         */
                        if(printLetter){
                            try{
                                lock.wait(); // releases lock and waits
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        // Critical section: printing number
                        System.out.println(i);

                        // Change turn back to letter thread
                        printLetter = true;

                        // Wake up waiting thread (letter thread)
                        lock.notify();
                    }
                }
            }
        };

        /*
         * Creating threads
         */
        Thread letterThread = new Thread(letterTask);
        Thread numberThread = new Thread(numberTask);

        /*
         * Starting threads
         * OS scheduler decides execution order
         */
        letterThread.start();
        numberThread.start();

        /*
         * main thread waits until both threads finish execution
         */
        try{
            letterThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
