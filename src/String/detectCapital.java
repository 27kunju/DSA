package String;

public class detectCapital {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;

        // Count uppercase letters
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) capitals++;
        }

        // Case 1: All letters uppercase
        if (capitals == word.length()) return true;

        // Case 2: All letters lowercase
        if (capitals == 0) return true;

        // Case 3: Only first letter uppercase
        return capitals == 1 && Character.isUpperCase(word.charAt(0));
    }

    public boolean detectCapitalUse2(String word) {

        // Case 1: ALL UPPERCASE
        if (checkRange(word, 'A', 'Z')) return true;

        // Case 2: all lowercase
        if (checkRange(word, 'a', 'z')) return true;

        // Case 3: Only first letter uppercase, rest lowercase
        if (Character.isUpperCase(word.charAt(0)) &&
                checkRange(word.substring(1), 'a', 'z')) {
            return true;
        }

        return false;
    }

    private boolean checkRange(String s, char start, char end) {
        for (char c : s.toCharArray()) {
            if (c < start || c > end) return false;
        }
        return true;
    }

}
