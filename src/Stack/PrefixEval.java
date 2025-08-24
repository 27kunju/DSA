package Stack;

import java.util.*;

class PrefixEval {
    public int evaluate(String exp) {
        Stack<Integer> st = new Stack<>();

        for(int i=exp.length()-1; i>=0; i--){
            char c = exp.charAt(i);
            if(Character.isDigit(c)){
                st.push(c - '0');
            } else {
                int a = st.pop();
                int b = st.pop();
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
