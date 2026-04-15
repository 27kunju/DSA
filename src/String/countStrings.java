package String;


/*
Amdocs interview
Given:

s (source string)
t (target string, not really affecting much except rule context)
Operation:
If string s contains 'a', you can repeatedly perform operation:
replace 'a' → 'b'
You can do it infinite times
If this leads to infinite number of distinct strings → return -1
Otherwise return number of distinct strings
 */
public class countStrings {

    public static int solve(String s, String t) {

        // If no 'a', no operation possible
        if (!s.contains("a")) {
            return 1;
        }

        // Check if transformation keeps 'a' alive
        // Here t = "abc" → contains 'a' again → cycle/infinite growth

        if (t.contains("a")) {
            return -1;
        }

        // Otherwise finite transformation
        return (int) Math.pow(2, countA(s));
    }

    private static int countA(String s) {
        int c = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') c++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(solve("aa", "b")); // -1
    }
}
