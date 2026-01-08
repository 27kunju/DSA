package MultiThreading;

public class VolatileVsAtomic {
    private static volatile int sharedCounter = 0;
    public static void main(String[] args) {

        Runnable volatileTask = () ->{
            for(int i = 0;i<100000;i++){
                sharedCounter++;
            }
        };

        Thread t1 = new Thread(volatileTask);
        Thread t2 = new Thread(volatileTask);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sharedCounter);

    }

    //output -less than 20000 each time code is executed.
}
