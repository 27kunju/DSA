package dp;

import java.util.HashSet;
import java.util.List;
import java.util.*;

public class wordbreak {

    private Boolean[] memo;
    private Set<String> set;
    private int n;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        memo = new Boolean[n]; // memo[i] → can we break from index i
        set = new HashSet<>(wordDict);

        return solve(0, s);
    }

    private boolean solve(int idx, String s) {

        if (idx == n) return true;
        if (memo[idx] != null) return memo[idx];

        for (int l = idx + 1; l <= n; l++) {

            String temp = s.substring(idx, l);
            if (set.contains(temp) && solve(l, s)) {
                return memo[idx] = true;
            }
        }
        return memo[idx] = false;
    }

}
