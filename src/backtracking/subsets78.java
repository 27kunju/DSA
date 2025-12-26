package backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();
         result.add(new ArrayList<>()); // empty subset

         for (int i = 0; i < nums.length; i++) {
             int n = result.size();

             for (int j = 0; j < n; j++) {
                 List<Integer> temp = new ArrayList<>(result.get(j));
                 temp.add(nums[i]);
                 result.add(temp);
             }
         }
         return result;
     }


    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int idx, int[] nums, List<Integer> temp) {

        // Every state is a valid subset
        result.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.length; i++) {

            // choose
            temp.add(nums[i]);

            // explore
            backtrack(i + 1, nums, temp);

            // un-choose
            temp.removeLast();
        }
    }
}
