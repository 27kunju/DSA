package TwoPointers;

public class ReverseArray {
    public static void main(String[] args) {
        //reverse array in place
        int[] arr = {1,2,3,4,5,6,7,8};
        //create temp arr
        int[] temp = new int[arr.length];
        int n = arr.length;

        // Traverse arr in reverse direction
        // and copy data to temp
        for (int i = 0; i < n; i++) {
            temp[i] = arr[n - 1 - i];
        }

        // Traverse temp in forward direction and
        // and copy back data to arr
        for(int i =0 ;i<arr.length; i++){
            arr[i] = temp[i];
        }

        display(arr);


//        This is a brute force approach using O(n) extra space (temp[]).
        
        reverseArrayUsing2Pointers(arr);
        display(arr);

    }

    public static void display(int[] arr){
        for(int x: arr){
            System.out.println(x+" ");
        }

    }

    public static void reverseArrayUsing2Pointers(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
