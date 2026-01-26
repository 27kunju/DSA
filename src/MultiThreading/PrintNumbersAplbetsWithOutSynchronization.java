package MultiThreading;

public class PrintNumbersAplbetsWithOutSynchronization {
    public static void main(String[] args) {
        Runnable printLetter = () ->{
            for(char ch = 'A'; ch <= 'Z'; ch++){
                System.out.println(ch);
            }

        };

        Runnable printNumber = () ->{
            for(int i = 0 ;i< 10 ;i++){
                System.out.println(i);
            }
        };

        Thread t1 = new Thread(printLetter);
        Thread t2 = new Thread(printNumber);

        t1.start();
        t2.start();



    }
}
