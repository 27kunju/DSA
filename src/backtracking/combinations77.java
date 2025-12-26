package backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinations77 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> temp) {

        // base case: k elements selected
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {

            // choose
            temp.add(i);

            // explore
            backtrack(i + 1, n, k, temp);

            // un-choose
            temp.removeLast();
        }
    }
}
