package Stream;

interface TriFuction<R,T,U,S>{

    R add(T a, U b, S c);

}

interface BiFunction<R,T,U>{
    R add(T a, U b);
}

public class customFunctionalInterface {
    public static void main(String[] args) {

        TriFuction<Integer, Integer, Integer,Integer> trifunction = ((a,b,c)->{
            return a+b+c;
        });

        System.out.println(trifunction.add(4,5,10));

        BiFunction<Integer,Integer,Integer> biFunction = ((a,b)-> a+b);

        System.out.println(biFunction.add(8,9));


    }
}
