package MultiThreading;

class MyCustomThread implements Runnable{
    int shared = 0;

    @Override
    public void run() {
        for(int i =0;i<100000;i++){
            shared++;
        }
    }

    public int getCount(){
        return shared;
    }
}

public class raceConditionsDemo {

    public static void main(String[] args) {
        MyCustomThread customThread = new MyCustomThread();

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

        System.out.println("final count valu:" + customThread.getCount());



    }
}
