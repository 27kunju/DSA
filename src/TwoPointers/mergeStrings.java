package TwoPointers;

public class mergeStrings {
    public static void main(String[] args) {
        String  word1 = "abc", word2 = "xyzasd";
        String mergered = mergedString(word1,word2);
        System.out.println(mergered);

    }

    public static String mergedString(String s, String t){
        int n = s.length();
        int m  = t.length();
        StringBuilder str = new StringBuilder();
        int i = 0; int j =0;
        while(i< n || j<m){
            if(i<n) str.append(s.charAt(i++));
            if(j<m) str.append(t.charAt(j++));
        }

        return str.toString();

    }
}
