package MultiThreading;

public class practice {
    public static void main(String[] args) {

        /*
        ===============================
        PROCESS vs THREAD
        ===============================

        Process:
        - An instance of a program in execution
        - Has its own memory space (heap, stack, code, data)
        - Heavyweight

        Thread:
        - A lightweight unit of execution inside a process
        - Multiple threads share the same process memory
        - Each thread has its own stack

        Real-world example:
        - Baking cookies = Process
        - Preparing dough, preheating oven, baking = Threads

        Multithreading allows multiple tasks to execute concurrently,
        improving responsiveness and CPU utilization.
        */


        /*
        ===============================
        SHARED RESOURCES & RACE CONDITIONS
        ===============================

        Since all threads belong to the same process,
        they can share resources (memory, objects, files).

        Example:
        - Two people cooking (threads)
        - Both using the same knife (shared resource)

        When multiple threads access and modify shared resources
        without proper coordination, race conditions occur.
        */


        /*
        ===============================
        TYPES OF RACE CONDITIONS
        ===============================

        1️⃣ Read-Modify-Write Race Condition

        Example:
        int count = 0;
        count = count + 1;

        This operation is NOT atomic.
        Internally it does:
        - Read count
        - Modify value
        - Write back

        If two threads execute this simultaneously:
        - Both may read the same old value
        - Both increment
        - Final result becomes incorrect
        */


        /*
        2️⃣ Check-Then-Act Race Condition

        Example (Banking scenario):

        if (balance >= 100) {
            balance -= 100;
        }

        Two threads may:
        - Both check balance >= 100 at the same time
        - Both pass the condition
        - Both deduct money

        Result:
        - Incorrect balance
        */


        /*
        ===============================
        HOW TO AVOID RACE CONDITIONS
        ===============================

        Bring coordination between threads to ensure thread safety.

        1️⃣ synchronized block / synchronized method

        - Uses intrinsic monitor lock on an object
        - Only ONE thread can execute synchronized code at a time
        - Other threads wait until lock is released

        Flow:
        Thread T1 → acquires lock → modifies shared data → releases lock
        Thread T2 → waits → acquires lock → modifies → releases lock
        */


        /*
        ===============================
        CONTEXT SWITCHING & THREAD COORDINATION
        ===============================

        Thread interruption occurs due to context switching,
        which is handled by the Operating System.

        Scenario:
        - Single CPU core
        - Multiple threads running

        The OS switches execution between threads
        to give an illusion of parallelism.
        */


        /*
        ===============================
        WHEN DO WE NEED COORDINATION?
        ===============================

        1️⃣ When threads access shared resources
           → Use synchronized / locks

        2️⃣ When threads need ordered execution
           (even if no shared data)

           Example:
           - One thread prints odd numbers
           - Another prints even numbers

           Due to context switching, output may interleave incorrectly.

           Solution:
           - wait() and notify() for coordination
           - One thread waits while the other executes
           - After finishing, it notifies the waiting thread
        */


        /*
        ===============================
        KEY INTERVIEW TAKEAWAYS
        ===============================

        ✔ Race condition occurs due to concurrent access
        ✔ synchronized ensures mutual exclusion
        ✔ wait()/notify() ensure thread coordination
        ✔ Context switching is controlled by OS
        ✔ Threads may need coordination even without shared data
        */
    }
}
