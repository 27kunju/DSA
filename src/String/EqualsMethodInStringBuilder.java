package String;

public class EqualsMethodInStringBuilder {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = new String("Java");
        System.out.println(s1.equals(s2)); // true

        StringBuilder sb1 = new StringBuilder("Java");
        StringBuilder sb2 = new StringBuilder("Java");
        System.out.println(sb1.equals(sb2)); // false
    }
}
