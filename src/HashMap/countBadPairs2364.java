package HashMap;

import java.util.HashMap;

public class countBadPairs2364 {

    public long countBadPairs(int[] nums) {
         int n = nums.length;
         int count = 0;

         for(int i =0;i<n;i++){
             for(int j=i+1;j<n;j++){
                 if(j-i !=nums[j] -nums[i]){
                     count++;
                 }
             }
         }

         return count;

     }

    public long countBadPairs2(int[] nums) {
        int n = nums.length;
        long result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            int totalPairsTillIndex = i;
            int goodPairs = mp.getOrDefault(diff, 0);

            result += (totalPairsTillIndex - goodPairs);

            mp.put(diff, goodPairs + 1);
        }

        return result;
    }
}
