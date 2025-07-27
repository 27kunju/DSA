package TwoPointers;

import java.util.Arrays;

public class boats {
    public static void main(String[] args) {
        int[] people  = {5,1,4,2};
        int limit = 6;
        int res = numRescueBoats(people, limit);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0, l = 0, r = people.length - 1;
        while (l <= r) {
            int remain = limit - people[r--];
            res++;
            if (l <= r && remain >= people[l]) {
                l++;
            }
        }
        return res;
    }
}
