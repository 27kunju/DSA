package Stack;

import java.util.Stack;

public class validParaenthies {

        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {

                // Push expected closing bracket
                if (c == '(') stack.push(')');
                else if (c == '{') stack.push('}');
                else if (c == '[') stack.push(']');

                    // c is a closing bracket
                else {
                    if (stack.isEmpty() || stack.pop() != c)
                        return false;
                }
            }

            // All opening brackets must be matched
            return stack.isEmpty();
        }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }


}
