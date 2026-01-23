package Interview;

import java.util.Random;


public class randomOTPNUmbers {
    public static void main(String[] args) {

        Random random = new Random();
        int otp = random.nextInt(90) + 10; // 10–99
//        System.out.println(otp);


        int otp2 = (int)(Math.random() * 90) + 10;
        System.out.println(otp2);


    }
}
