package MultiThreading;

public class PrintNumbersAndAlphabets {

    private static boolean printLetter = true;

    private static final Object lock = new Object();

    public static void main(String[] args){

        Runnable letterTask = new Runnable(){
            @Override
            public void run() {
                for(char ch = 'A';ch<='Z';ch++){
                    synchronized (lock){

                        if(!printLetter){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("" +ch);
                        printLetter = false;
                        lock.notify();

                    }


                }

            }
        };

        Runnable numberTask = new Runnable(){
            @Override
            public void run() {
                for(int i = 1;i<=26;i++){
                   synchronized (lock){
                       if(printLetter){
                           try{
                               lock.wait();
                           } catch (InterruptedException e) {
                               throw new RuntimeException(e);
                           }
                       }

                       System.out.println("" +i);
                       printLetter = true;
                       lock.notify();
                   }
                }

            }
        };

        Thread letterThread = new Thread(letterTask);
        Thread numberThread = new Thread(numberTask);

        letterThread.start();
        numberThread.start();

        try{
            letterThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
