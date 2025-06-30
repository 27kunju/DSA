package String;

public class AnagramsUsingHashTable {
    public static void main(String[] args) {
        String s1 = "decimal";
        String s2 = "medical";

        if (s1.length() != s2.length()) {
            System.out.println("Not Anagram");
            return;
        }

        char[] A = s1.toLowerCase().toCharArray();
        char[] B = s2.toLowerCase().toCharArray();

        int[] H = new int[26]; // For 'a' to 'z'

        for (int i = 0; i < A.length; i++) {
            H[A[i] - 'a']++;
        }

        for (int i = 0; i < B.length; i++) {
            H[B[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (H[i] != 0) {
                System.out.println("Not Anagram");
                return;
            }
        }

        System.out.println("Anagram");
    }
}
