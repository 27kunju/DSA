package String;

public class ReverseString {

    public static void main(String[] args) {
        String name = "ashwini";
        //name.reverse() is not possible. string is immutable. we cant change it
        String rev = "";
        for(int i = name.length()-1 ; i >=0 ; i--){
            rev += name.charAt(i);
        }

        System.out.println(rev);

        //2. using string buffer
        StringBuffer sf = new StringBuffer(name);
        sf.reverse();
        System.out.println(sf);

        //3. using string builder
        StringBuilder sb = new StringBuilder(name);
        sb.reverse();
        System.out.println(sb);


    }

    void reverseString(String s) {
        char[] arr = s.toCharArray();  // Convert string to char array
        int l = 0, r = arr.length - 1;

        while (l < r) {
            // Swap characters
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        // Convert back to string and print
        String reversed = new String(arr);
        System.out.println(reversed);
    }

}
