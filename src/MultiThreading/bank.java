package MultiThreading;

class jointAccount {

    int balance ;
    String name;

    jointAccount(int balance ){
        this.balance = balance;

    }

    public synchronized void deposit(String name, int money){
        balance +=money;

        System.out.println(name+" deposited" + money);
        System.out.println("Balance after deposit"+ balance);

    }

    public synchronized void withdraw( String name,int money){
        if(money>balance){
            System.out.println(name+"you can withdraw"+money);
            System.out.println("your balance is"+balance);
        }else{
            balance -=money;
            System.out.println(name+"withdramn"+money);
            System.out.println("balance after withdrawal"+balance);
        }
    }
    public int getBalance() {
        return balance;
    }
}

public class bank{
    public static void main(String[] args) {

        jointAccount j1 = new jointAccount(100);

        // Multiple threads for different transactions
        Thread t1 = new Thread(() -> j1.withdraw("Arnab", 20));
        Thread t2 = new Thread(() -> j1.withdraw("Monodwip", 40));
        Thread t3 = new Thread(() -> j1.deposit("Arnab", 35));
        Thread t4 = new Thread(() -> j1.withdraw("Monodwip", 80));
        Thread t5 = new Thread(() -> j1.withdraw("Arnab", 40));

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
