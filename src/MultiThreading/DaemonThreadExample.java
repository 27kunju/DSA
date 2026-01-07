package MultiThreading;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread userThread1 = new Thread(() ->{
            try{
                for(int i = 0;i<=10;i++){
                    System.out.println("user thread" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

//        Thread userThread2 = new Thread(() ->{
//            for(int i = 0;i<=10;i++){
//                System.out.println("user thread" + i);
//            }
//        });

        Thread daemonThread = new Thread(() ->{

            try {
                for (int i = 0; i <= 10; i++) {
                    System.out.println("daemon thread" + i);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        userThread1.start();
//        userThread2.start();
        daemonThread.setDaemon(true);
        daemonThread.start();



    }
}
