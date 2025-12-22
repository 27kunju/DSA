package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class permutations47 {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;

    private void backtrack(int[] nums, List<Integer> temp) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            temp.add(nums[i]);

            backtrack(nums, temp);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);        // required for duplicate handling
        used = new boolean[nums.length];

        backtrack(nums, new ArrayList<>());
        return result;
    }
}
