package String;

public class makeGoodString {
    public String makeGood(String s) {
        StringBuilder str= new StringBuilder();

        for (char c : s.toCharArray()) {
            int size = str.length();
            if (size > 0 && Math.abs(str.charAt(size - 1) - c) == 32) {
                // remove the bad pair
                str.deleteCharAt(size - 1);
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }
}
