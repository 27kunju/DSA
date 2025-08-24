package Stack;

import java.util.*;

class PostfixEval {
    public int evaluate(String exp) {
        Stack<Integer> st = new Stack<>();

        for(char c : exp.toCharArray()){
            if(Character.isDigit(c)){
                st.push(c - '0');
            } else {
                int b = st.pop();
                int a = st.pop();
                switch(c){
                    case '+': st.push(a+b); break;
                    case '-': st.push(a-b); break;
                    case '*': st.push(a*b); break;
                    case '/': st.push(a/b); break;
                }
            }
        }
        return st.pop();
    }
}
