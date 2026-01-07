package String;

public class ComplementPairs {

    // it was swiggy OA
    public static int countPairs(String s) {
        int[] freq = new int[26];

        // Step 1: frequency count
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int pairs = 0;

        // Step 2: process only half to avoid double counting
        for (char c = 'a'; c <= 'm'; c++) {
            char comp = (char) ('a' + ('z' - c));
            pairs += Math.min(freq[c - 'a'], freq[comp - 'a']);
        }

        return pairs;
    }

    public static int countPairsOnePass(String s) {
        int[] freq = new int[26];
        int pairs = 0;

        for (char c : s.toCharArray()) {
            char comp = (char) ('a' + ('z' - c));

            if (freq[comp - 'a'] > 0) {
                pairs++;
                freq[comp - 'a']--; // consume complement
            } else {
                freq[c - 'a']++;
            }
        }
        return pairs;
    }


    public static void main(String[] args) {
        System.out.println(countPairs("azby"));     // 2
        System.out.println(countPairs("aazz"));     // 2
        System.out.println(countPairs("abcxyz"));   // 3
        System.out.println(countPairsOnePass("wjlahohpec"));      // 0
    }
}
