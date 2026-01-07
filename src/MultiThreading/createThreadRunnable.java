package MultiThreading;

class mycustom implements Runnable{

    @Override
    public void run() {
        System.out.println("using runnable" + Thread.currentThread().getName());
    }
}

public class createThreadRunnable {

    public static void main(String[] args) {
        mycustom customThread = new mycustom();

        //we get error ,because we dont have start method in runnable
//        t1.start();

        //we have to pass the obj
        Thread t1 = new Thread(customThread);
        t1.start();

        // we are able to create multiple threads using same object
        Thread t2 = new Thread(customThread);
        t2.start();
    }
}
