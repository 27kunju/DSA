package MultiThreading;

class MyCustomThread implements Runnable{
    int shared = 0;


    //In synchronized(this), this refers to the shared object (MyCustomThread instance), NOT to the Thread object.
    //Yes, the synchronized block allows only one thread at a time to execute that block for that object.
    @Override
    public void run() {
        for(int i =0;i<100000;i++){

            /*
            this = instance of MyCustomThread
            NOT t1
            NOT t2
            Why?
            run() is executed on the Runnable object
            t1 and t2 both call run() on the same customThread instance

            2️⃣ What does synchronized(this) actually do?
             synchronized (this) {
             shared++;
             }
             Means:
             Acquire the monitor lock of the MyCustomThread object
             Only ONE thread can hold this lock at a time
             Other threads must wait
              Are t1 and t2 synchronized with each other?
              YES Because:
              Both threads synchronize on the same lock object
              Lock = customThread
              So execution becomes:

Thread t1 → acquires lock → increments → releases lock
Thread t2 → acquires lock → increments → releases lock
Never simultaneously.
             */
            synchronized (this) {
                shared++;
            }
        }
    }

    public int getCount(){
        return shared;
    }
}

public class raceConditionsDemo {

    public static void main(String[] args) {
        MyCustomThread customThread = new MyCustomThread();
//
        Thread t1 = new Thread(customThread);
        Thread t2 = new Thread(customThread);



        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("final count value:" + customThread.getCount());



    }
}
