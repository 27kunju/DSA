package Arrays;

public class faithfulNumber {

    public long findFaithNumber(int n){

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (long) Math.pow(7, i);
        }

        return sum;
    }
}
