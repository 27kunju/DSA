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

        synchronized provides:
        ✔ Mutual exclusion
        ✔ Visibility guarantee
        ✔ Happens-before relationship
        */


        /*
        ===============================
        INTRINSIC LOCK (MONITOR LOCK)
        ===============================

        synchronized works NOT because of the variable name "lock",
        but because EVERY Java object has an intrinsic monitor lock.

        Example:
        Object lock = new Object();

        synchronized(lock) {
            // acquires monitor lock of 'lock' object
        }

        Best practice:
        - Use private final Object lock
        - Avoid synchronizing on 'this' in shared classes
        */


        /*
        ===============================
        wait(), notify(), notifyAll()
        ===============================

        These methods belong to Object class (NOT Thread).

        Rules:
        - Must be called inside synchronized block
        - Operate on the same monitor lock object

        wait():
        - Releases the monitor lock
        - Puts thread into waiting state

        notify():
        - Wakes ONE waiting thread

        notifyAll():
        - Wakes ALL waiting threads
        - Safer when multiple conditions exist
        */


        /*
        ===============================
        IF vs WHILE IN wait()
        ===============================

        Always use WHILE, not IF.

        Reason:
        - Spurious wakeups
        - Condition may change before thread resumes

        while (!condition) {
            lock.wait();
        }

        Interview rule:
        → wait() must always be used inside a loop
        */


        /*
        ===============================
        CONTEXT SWITCHING
        ===============================

        Context switching is done by the Operating System.

        Scenario:
        - Single CPU core
        - Multiple threads

        OS pauses one thread and resumes another,
        giving illusion of parallel execution.

        Context switching itself does NOT cause race conditions.
        Lack of synchronization does.
        */


        /*
        ===============================
        WHEN DO WE NEED COORDINATION?
        ===============================

        1️⃣ When threads access shared mutable data
           → Use synchronized / locks / atomic classes

        2️⃣ When threads need ordered execution
           (even without shared data)

           Example:
           - One thread prints odd numbers
           - Another prints even numbers

           Due to context switching, output may interleave.

           Solution:
           - wait() and notify()
           - One thread waits
           - Other thread executes
           - Then notifies waiting thread
        */


        /*
        ===============================
        EXPLICIT LOCK vs synchronized
        ===============================

        synchronized:
        - Implicit locking
        - JVM-managed
        - Uses intrinsic monitor lock

        ReentrantLock:
        - Explicit locking
        - lock() / unlock()
        - tryLock(), fairness, interruptible
        - Uses Condition instead of wait/notify

        NOTE:
        ❌ Do NOT mix synchronized and ReentrantLock
        */


        /*
        ===============================
        join() METHOD
        ===============================

        join():
        - Makes calling thread wait until target thread finishes
        - Establishes happens-before relationship

        Used when:
        - You need result after a thread completes
        */


        /*
        ===============================
        volatile vs synchronized (Quick)
        ===============================

        volatile:
        ✔ Visibility
        ✔ Ordering
        ❌ Atomicity

        synchronized:
        ✔ Visibility
        ✔ Atomicity
        ✔ Mutual exclusion
        */

        /*

        Synchronized keyword in java

        1.synchronized keyword to avoid race conditions and maintain data integrity in multhithreading
        2. Can be used only with : instance method,static method, code block inside an instance/static method
        3. Only one thread can access a synchronized method/block at an instance of time
        4. On encountering a synchronized method/block the current thread uses an intrinsic or monitor lock tht is bound to an object.
        5.Increases the waiting time of the thread and lowers performances.


        Volatile Keyword in java

        1.volatile incdicates tht a field may be accesssed by multiple java threads.
        2. Helps to resolve this issue by making the volatile variable visible to all threads.
        3. Every read and write operation performed by each thread foes straight ot the main memory.
        4. It guarantees visibility but does not prevent multiple threads from accessing and modifying the variable simultaneously.


        when to use volatile

        1. To ensure that changes made by one thread to a shared variable are immediately visible to other threads without the need for explicit locking mechanisms.


        Atomic keyword in java
        1.Atomic classes ensure that an operation will be an tomic operation.
        2.Atomic variables have the added feature of amking non atomic operations atomic



         */


        /*
        ===============================
        KEY INTERVIEW TAKEAWAYS
        ===============================

        ✔ Race conditions occur due to concurrent access
        ✔ synchronized ensures mutual exclusion + visibility
        ✔ wait/notify provide thread coordination
        ✔ Context switching is OS responsibility
        ✔ Threads may need coordination even without shared data
        ✔ Always use while with wait()
        ✔ Prefer notifyAll when multiple threads are waiting
        */
    }
}
