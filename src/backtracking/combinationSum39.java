package backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinationSum39 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(0, candidates, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int idx, int[] candidates,
                           int target, List<Integer> temp) {

        // base case
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) return;

        for (int i = idx; i < candidates.length; i++) {

            // choose
            temp.add(candidates[i]);

            // reuse same element → i (not i+1)
            backtrack(i, candidates, target - candidates[i], temp);

            // un-choose
            temp.removeLast();
        }
    }
}
