package MultiThreading;

public class PracticeThread {
    private static boolean printLetter = true;
    private static final Object lock = new Object();
    public static void main(String[] args) {


        Runnable numberPrint = () ->{
            for(int i = 1;i<=26;i++) {

                synchronized (lock) {

                    if (printLetter) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println(i);
                    printLetter = true;
                    lock.notify();


                }
            }

        };

        Runnable letterPrint = () ->{
            for(char ch = 'a'; ch<='z' ;ch++){
                synchronized (lock){
                    if(!printLetter){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println(ch);
                    printLetter = false;
                    lock.notify();
                }
            }
        };

        Thread t1 = new Thread(letterPrint);
        Thread t2 = new Thread(numberPrint);

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
