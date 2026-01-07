package MultiThreading;

 class customThread extends Thread{

    @Override
    public void run() {
       System.out.println("my custom class");
    }
}


public class createThread{
    public static void main(String[] args) {
        customThread t1 = new customThread();
        t1.start(); // create a new thread

        customThread t2 = new customThread();
        t2.start();;
    }



}
