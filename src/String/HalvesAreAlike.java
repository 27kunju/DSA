package String;

public class HalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;

        int count = 0;

        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) count++;
        }

        for (int i = mid; i < n; i++) {
            if (isVowel(s.charAt(i))) count--;
        }

        return count == 0;
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
