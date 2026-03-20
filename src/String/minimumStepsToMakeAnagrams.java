package String;

public class minimumStepsToMakeAnagrams {
    public int minSteps(String s, String t) {
        int n = s.length();

        int[] mp = new int[26];

        for (int i = 0; i < n; i++) {
            mp[s.charAt(i) - 'a']++;
            mp[t.charAt(i) - 'a']--;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            result += Math.max(0, mp[i]);
        }

        return result;
    }
    /*

    Why Math.max(0, mp[i])?
result += Math.max(0, mp[i]);

We only care about positive differences.

Why? Because positive difference means t needs to gain those characters to match s.

Example:

s = "bab", t = "aba"
mp after loop:
a → -1 (t has one extra 'a')
b → 1  (t needs one 'b')

Math.max(0, -1) → 0 (t already has extra 'a', no step needed)

Math.max(0, 1) → 1 (t needs 1 'b', we must replace)

✅ So result = 1 → minimum steps needed.
     */
}
