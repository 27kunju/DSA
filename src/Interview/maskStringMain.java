package Interview;

public class maskStringMain {

    public static void main(String[] args) {

        String s = "'Sachin' Tendulkar";
        System.out.println(maskString2(s));
    }

    public static String maskString2(String s) {

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '\'') {

                result.append('\'');

                int index = i + 1;

                while (index < s.length() && s.charAt(index) != '\'') {
                    result.append('*');
                    index++;
                }

                if (index < s.length()) {
                    result.append('\'');
                }

                i = index + 1;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}
