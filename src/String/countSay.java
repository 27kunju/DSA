package String;

public class countSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        // Get previous term
        String say = countAndSay(n - 1);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < say.length(); i++) {
            char ch = say.charAt(i);
            int count = 1;

            // Count consecutive repeating characters
            while (i < say.length() - 1 && say.charAt(i) == say.charAt(i + 1)) {
                count++;
                i++;
            }

            // Append count + character
            res.append(count);
            res.append(ch);
        }

        return res.toString();
    }
}
