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

}
