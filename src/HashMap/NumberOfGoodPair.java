package HashMap;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPair {

    /*
    https://leetcode.com/problems/number-of-good-pairs/

    Pattern: Frequency Counting / HashMap Accumulation
Each new element forms pairs with all identical elements seen before
🔹 Core Idea of the Pattern
Instead of checking all (i, j) pairs (brute force), we:
•	Keep track of how many times each value has already appeared
•	Use that count to directly compute how many new pairs are formed



     */



    public int identicalPairs(int[] nums){
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        int count =0;

        for(int i = 0;i<n;i++){

            if(map.containsKey(nums[i])){
                count += map.get(nums[i]);
            }

            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        return count ;
    }
}
