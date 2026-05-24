package Interview.WissenTechnology;
import java.util.*;

/*
Example [1,2,3,4,5]

Step 1: take odd positions → add & remove 1,3,5
Remaining: [2,4]
Step 2: again take odd positions → add & remove 2
Remaining: [4] (stop)

Sum = 1+3+5+2 = 11

leetcode 390
 */

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
        Interview.RandomGame rg = new Interview.RandomGame();
        System.out.println(rg.getPoints(5)); // 11
    }
}
