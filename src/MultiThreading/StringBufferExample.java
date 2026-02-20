package MultiThreading;

public class StringBufferExample {
    public static void main(String[] args) throws InterruptedException {
//        StringBuilder sb = new StringBuilder();
//
//        Runnable task = () -> {
//            for (int i = 0; i < 10000; i++) {
//                sb.append("A");
//            }
//        };
//
//        Thread t1 = new Thread(task);
//        Thread t2 = new Thread(task);
//
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//        System.out.println(sb.length());

        StringBuffer sb = new StringBuffer();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                sb.append("A");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(sb.length());


    }
}
