package String;
import java.util.Arrays;
public class permatationOfString {
    public static boolean checkInclusion(String s1, String s2) {
          int m = s1.length();
          int n = s2.length();

          if(m>n) return false;

          int[] s1_freq = new int[26];
          int[] s2_freq = new int[26];

          for(int i = 0;i<m;i++){
              s1_freq[s1.charAt(i) - 'a']++;
          }

          int i = 0, j = 0;
          while(j<n){

              s2_freq[s2.charAt(j)-'a']++;

              if(j-i+1>m){
                  s2_freq[s2.charAt(i) -'a']--;
                  i++;
              }

             if(Arrays.equals(s1_freq,s2_freq)) return true;
             j++;
          }

          return false;

    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1,s2));
    }
}
