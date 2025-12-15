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
}
