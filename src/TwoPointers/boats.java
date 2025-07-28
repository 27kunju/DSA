package TwoPointers;

import java.util.Arrays;

public class boats {
    public static void main(String[] args) {
        int[] people  = {5,1,4,2,3,6,7};
        int limit = 6;
        int res = numRescueBoats(people, limit);
        System.out.println(res);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0, l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[r] > limit) {
                System.out.println("Person with weight " + people[r] + " cannot be rescued.");
                r--;
                continue;
            }
            int remain = limit - people[r--];

            res++;
            if (l <= r && remain >= people[l]) {
                l++;
            }
        }
        return res;
    }
}
