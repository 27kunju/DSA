package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

class BankAccount2 {

    private double balance;
    private final ReentrantLock lock = new ReentrantLock(true); // fair lock

    public BankAccount2(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " trying to withdraw " + amount);

            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrawal successful. Remaining balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " withdrawal failed. Insufficient balance: " + balance);
            }

        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class PracticeReentrant{
    public static void main(String[] args) {

        BankAccount2 account = new BankAccount2(1000);

        Thread t1 = new Thread(() -> account.withdraw(700), "User-1");
        Thread t2 = new Thread(() -> account.withdraw(500), "User-2");
        Thread t3 = new Thread(() -> account.withdraw(300), "User-3");

        t1.start();
        t2.start();
        t3.start();
    }

    /*
    Balance is shared resource.
Multiple users withdrawing at same time.
ReentrantLock ensures only one thread modifies balance at a time.
Fair lock ensures first come first served.
     */
}