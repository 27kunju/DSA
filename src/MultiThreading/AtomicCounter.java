package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
//    private static int counter = 0;

   static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        Runnable increment = new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<=100000;i++){
                    counter.incrementAndGet();
                }
            }
        };

        Runnable decrement = new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<=100000;i++){
                    counter.decrementAndGet();
                }
            }
        };

        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(decrement);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("final:" +counter);
    }
}
