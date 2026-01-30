package BinarySearch;

public class FindPowerOfNumber {
    public static void main(String[] args) {

        int n = 2;
        int p = 10;

        double x = findPower(n, p);
        System.out.println(x);
    }

    public static double findPower(int n, int p ){
        long power = p;

        if(power<0){
            n = 1/n;
            power = -power;

        }

        double result = 1.0;

        while(power> 0){
            if((power &1) == 1 ){
                result *= n;
            }
            n *=n;
            power >>=1;

        }

        return result;

    }
}
