package Stream;

public class instanceOperatorExample {
    public static void main(String[] args) {

        Object obj = new Object();
        obj = "ashwini";

        if(obj instanceof  String){
            System.out.println(((String) obj).length());
        }

        if(obj instanceof  String s){
            System.out.println(s.length());
        }
    }
}
