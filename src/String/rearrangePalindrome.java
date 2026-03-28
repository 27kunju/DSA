package String;

public class rearrangePalindrome {

    public String canRearrangePalindrome(String s){

        int[] freq = new int[26];

        for(char ch : s.toCharArray()){

            freq[ch - 'a']++;
        }

        int oddCount = 0;


        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        if(oddCount>1){
            return "NO";
        }

        return "YES";
    }
}
