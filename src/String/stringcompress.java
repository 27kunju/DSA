package String;

public class stringcompress {

    public int compress(char[] chars) {
        int n = chars.length;

        int index = 0;  // write pointer
        int i = 0;      // read pointer

        while (i < n) {
            char curr_char = chars[i];
            int count = 0;

            // Count occurrences
            while (i < n && chars[i] == curr_char) {
                count++;
                i++;
            }

            // Write the character
            chars[index++] = curr_char;

            // Write count if greater than 1
            if (count > 1) {
                String count_str = String.valueOf(count);
                for (char ch : count_str.toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }

        return index;
    }
}
