package Arrays;

public class MoveAllZeroesFront {
    public static void main(String[] args) {
        int[] arr = {0,1,4,5,0,3, 0,5};
        int n = arr.length;
        int j = arr.length -1;
        for(int i = n -1; i>=0 ; i--){
            if(arr[i] !=0){
                arr[j] = arr[i];
                j--;
            }
        }

        while(j>=0){
            arr[j] = 0;
            j--;
        }

        for(int x : arr){
            System.out.println(x);
        }
    }
}
