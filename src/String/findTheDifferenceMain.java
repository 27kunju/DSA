package String;

public class findTheDifferenceMain {
    public static void main(String[] args) {
        String  s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s, t));

    }

    public static char findTheDifference(String s , String t){
        char[] tarr = t.toCharArray();
        char[] sarr = s.toCharArray();

        for(int i =0; i< sarr.length ; i++){

            if(sarr[i] != tarr[i]){
                return tarr[i];

            }
        }

        return tarr[tarr.length -1];
    }
}
