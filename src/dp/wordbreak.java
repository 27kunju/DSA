package dp;

import java.util.HashSet;
import java.util.List;
import java.util.*;

public class wordbreak {

    Set<String> set;
    int[] memo;
    int n;

    public boolean wordBreak2(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();
        memo = new int[n];

        Arrays.fill(memo, -1); // -1 = not computed

        return solve(0, s);
    }

    public boolean solve(int idx, String s) {
        if (idx == n) return true;

        if (memo[idx] != -1) {
            return memo[idx] == 1;
        }

        for (int l = idx + 1; l <= n; l++) {
            String temp = s.substring(idx, l);

            if (set.contains(temp) && solve(l, s)) {
                memo[idx] = 1;
                return true;
            }
        }

        memo[idx] = 0;
        return false;
    }

}
