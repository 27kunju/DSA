package greedy;

import java.util.Arrays;

public class assignCookie {

    /*
    We sort both arrays and always try to satisfy the least greedy child with the smallest possible cookie.
This ensures we don’t waste larger cookies on smaller needs, maximizing total satisfied children.
     */
    public int findContentChildren(int[] g, int[] s) {

        if (g.length == 0 || s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child index
        int j = 0; // cookie index
        int happyKids = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                happyKids++; // child satisfied
                i++;
                j++;
            } else {
                j++; // cookie too small, try next bigger cookie
            }
        }

        return happyKids;
    }
}
