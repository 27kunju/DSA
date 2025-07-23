package TwoPointers;

public class validPalindrome {
    public static void main(String[] args) {
        String s = "abbadc";
        System.out.println(validatePalindrome(s));

    }

    public static boolean validatePalindrome(String s){
        int l = 0;
        int r = s.length() -1 ;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return isPalindrome(s , l+1, r) || isPalindrome(s, l, r-1);

            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int l , int r){

        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
