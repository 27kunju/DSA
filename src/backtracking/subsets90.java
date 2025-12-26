package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class subsets90 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 1️⃣ sort
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int idx, int[] nums, List<Integer> temp) {

        // every state is a valid subset
        result.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.length; i++) {

            // 2️⃣ skip duplicates at same level
            if (i > idx && nums[i] == nums[i - 1])
                continue;

            // choose
            temp.add(nums[i]);

            // explore
            backtrack(i + 1, nums, temp);

            // un-choose
            temp.removeLast();
        }
    }
}
