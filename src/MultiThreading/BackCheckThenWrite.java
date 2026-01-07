package MultiThreading;

public class BackCheckThenWrite implements  Runnable{
    int balance = 100;
    @Override
    public void run() {
        System.out.println("Waiting to withdraw money:" + Thread.currentThread().getName());

        if(balance >= 100){
            System.out.println("withdrawing money:"+Thread.currentThread().getName());
            balance -=50;
        }else{
            System.out.println("withdrawal not done for :" +Thread.currentThread().getName());
            return;
        }
        System.out.println("after withdrawal:" + balance);

    }

    public int getBalance(){
        return balance;
    }

    public static void main(String[] args) {
        BackCheckThenWrite backCheckThenWrite = new BackCheckThenWrite();
        Thread t1 = new Thread(backCheckThenWrite, "ash");
        Thread t2 = new Thread(backCheckThenWrite, "tanu");

        t1.start();
        t2.start();


    }
}
