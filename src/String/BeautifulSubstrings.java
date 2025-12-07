package String;

import java.util.HashMap;
import java.util.Map;

public class BeautifulSubstrings {
    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int vowels = 0;
            int consonants = 0;

            for (int j = i; j < n; j++) {
                if (isVowel(s.charAt(j))) {
                    vowels++;
                } else {
                    consonants++;
                }

                if (vowels == consonants && (vowels * consonants) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // find smallest step such that (step * step) % k == 0
    private int computeStep(int k) {
        for (int step = 1; step <= k; step++) {
            if ((long) step * step % k == 0)
                return step;
        }
        return k;
    }

    public int beautifulSubstrings2(String s, int k) {
        int n = s.length();
        int step = computeStep(k);

        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", 1); // base prefix

        int vowels = 0, consonants = 0, ans = 0;

        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) vowels++;
            else consonants++;

            int diff = vowels - consonants;
            int mod = vowels % step;

            String key = diff + "#" + mod;

            ans += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return ans;
    }
}
