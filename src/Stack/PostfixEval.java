package Stack;

import java.util.*;

class PostfixEval {

    public int evaluate(String exp) {
        Stack<Integer> st = new Stack<>();

        for (char c : exp.toCharArray()) {

            if (Character.isDigit(c)) {
                st.push(c - '0');
            } else {

                if (st.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }

                int b = st.pop();
                int a = st.pop();

                int result = switch (c) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> a / b;
                    default -> throw new IllegalArgumentException("Invalid operator: " + c);
                };

                st.push(result);
            }
        }

        if (st.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return st.pop();
    }
}
