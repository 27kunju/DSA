package Arrays;

public class MoveNegativeToLeft {

    public static void main(String[] args) {
        int[] arr = {-6,3,-8,10,5,-7,9,12,-4,2};
        int i =0 , j = arr.length-1;

        while(i<j){
            while(arr[i] <0) i++;
            while(arr[j]>=0) j--;
            if(i<j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }

        for(int k : arr){
            System.out.println(k);
        }


    }
}
