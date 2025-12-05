package String;

public class buddyStrings {

    // Helper to check if string has duplicate characters
    public boolean checkFreq(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
            if (arr[ch - 'a'] > 1) return true;
        }
        return false;
    }

    public boolean buddyStrings1(String s, String goal) {
        if (s.length() != goal.length()) return false;

        // Case 1: Strings are equal, check for duplicates
        if (s.equals(goal)) {
            return checkFreq(s);
        }

        // Case 2: Strings are different, find mismatch indices
        int[] index = new int[2];
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (idx >= 2) return false; // more than 2 mismatches
                index[idx++] = i;
            }
        }

        // Must have exactly 2 mismatches
        if (idx != 2) return false;

        // Swap characters at mismatch positions
        char[] sArr = s.toCharArray();
        char temp = sArr[index[0]];
        sArr[index[0]] = sArr[index[1]];
        sArr[index[1]] = temp;

        // Check if swap makes strings equal
        return new String(sArr).equals(goal);
    }
}
