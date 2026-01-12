package Interview;

public  class demo {
    public static void main(String[] args) {
        String s2 = "123";
        String s = new String("123");
        System.out.println(s==s2); //false
        System.out.println(s.equals(s2)); //true

//        String s1 = s;

//
//        System.out.println(s ==s1); //true
//        System.out.println(s1 ==s2); // false
//        System.out.println(s.equals(s1)); //true
//        System.out.println(s1.equals(s)); //true
//        System.out.println("123".equals(s)); //true
//        System.out.println(s2.equals(s)); //true


    }


}