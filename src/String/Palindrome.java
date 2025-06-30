package String;

public class Palindrome {
    public static void main(String[] args) {
        String s = "";
        System.out.println(isPalidrome(s));
    }
    public static boolean isPalidrome(String s){
        if( s == null || s.isEmpty()) return true;
        s = s.toLowerCase();
        for(int i = 0; i<=s.length()/2 ; i++){
            char start = s.charAt(i);
            char end = s.charAt(s.length() -1 -i);

            if(start != end){
                return false;
            }
        }
        return true;

    }
}
