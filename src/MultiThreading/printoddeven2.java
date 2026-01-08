package MultiThreading;

public class printoddeven2 {

    private static boolean isOdd = false;
    private static final Object lock = new Object();


    public static void main(String[] args) {

        Runnable odd = new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 1;i<=100; i +=2){

                        synchronized (lock){
                           if(!isOdd){
                               lock.wait();
                           }
                           System.out.println("odd:" +i);
                           isOdd = false;
                           lock.notify();
                        }

                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        Runnable even = new Runnable() {
            @Override
            public void run() {

                try{
                    for(int i = 0;i<=100;i +=2){
                        synchronized (lock){
                            if(isOdd){
                                lock.wait();
                            }
                            System.out.println("even:" +i);
                            isOdd = true;
                            lock.notify();
                        }
                    }
                } catch (InterruptedException e) {
                   System.out.println(e.getMessage());
                }

            }
        };

        Thread t1 = new Thread(odd, "odd");
        Thread t2 = new Thread(even, "event");


        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
