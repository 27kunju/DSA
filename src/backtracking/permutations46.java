package backtracking;

import java.util.ArrayList;
import java.util.List;

public class permutations46 {
    List<List<Integer>> result = new ArrayList<>();
    int n;

    private void solve(int idx, int[] nums) {

        if (idx == n) {
            List<Integer> perm = new ArrayList<>();
            for (int x : nums) perm.add(x);
            result.add(perm);
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(nums, i, idx);
            solve(idx + 1, nums);
            swap(nums, i, idx); // backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        solve(0, nums);
        return result;
    }
}
