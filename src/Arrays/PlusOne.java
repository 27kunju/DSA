package Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,1};
        int digit = getDigit(arr);
        int[] plusarr = getArrPlus(digit);
        System.out.println(digit);
        for(int x : plusarr){
            System.out.println(x);
        }
    }

    public static int getDigit(int[] arr){

        int num  =0;
        for(int i = 0; i< arr.length ; i++){
            num = num*10 + arr[i];
        }

        return num;
    }

    public static int[] getArrPlus(int digit){
        int count = 0;
        int temp = digit;
        while(temp > 0){
            temp = temp /10;
            count++;
        }
        int[] arr = new int[count];

        for(int i = count -1 ; i>=0 ; i--){
            arr[i] = digit %10;
            digit = digit/10;
        }
        return arr;
    }
}
