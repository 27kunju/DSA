package MultiThreading;

public class printLettersNumbers {
    public static void main(String[] args) {
        Runnable printNumbers = ()->{
            for(int i = 1;i<=26;i++){
                System.out.println(i +" ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        };

        Runnable printLetter = ()->{
            for(char ch = 'A' ; ch<='Z';ch++){
                System.out.println(ch);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(printNumbers);
        Thread t2 = new Thread(printLetter);

        t1.start();
        t2.start();
    }
}
