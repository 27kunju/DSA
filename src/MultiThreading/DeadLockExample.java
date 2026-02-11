package MultiThreading;

class DeadlockExample {

    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (LOCK_A) {
                System.out.println("Thread 1 acquired LOCK_A");

                try { Thread.sleep(100); } catch (Exception ignored) {}

                synchronized (LOCK_B) {
                    System.out.println("Thread 1 acquired LOCK_B");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (LOCK_B) {
                System.out.println("Thread 2 acquired LOCK_B");

                try { Thread.sleep(100); } catch (Exception ignored) {}

                synchronized (LOCK_A) {
                    System.out.println("Thread 2 acquired LOCK_A");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

