package Interview;

import java.util.*;

public class RandomGame {

    public int getPoints(int n) {

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        int sum = 0;

        while(list.size() > 1) {

            List<Integer> remaining = new ArrayList<>();

            for(int i = 0; i < list.size(); i++) {

                if(i % 2 == 0) {   // odd position (1st, 3rd, 5th...)
                    sum += list.get(i);
                } else {
                    remaining.add(list.get(i));
                }
            }

            list = remaining;
        }

        return sum;
    }

    public static void main(String[] args) {
        RandomGame rg = new RandomGame();
        System.out.println(rg.getPoints(5)); // 11
    }
}