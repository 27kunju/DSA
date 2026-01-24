package Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] =2;
        arr[1] = 5;
        arr[2] = 7;
        arr[3] = 9;
        arr[4] = 11;

        int size = 5;

        int k = 2;

        /*

         When we say “left rotate by k”: Each element moves k positions to the left
         Rotating by k positions = shifting the array left k times = moving k elements

         what does it mean k = 8, n = 5
         Left rotation by 8 positions = left rotation by 3 positions
         Because: Rotating by 5 brings the array back to the same state
                  Extra rotations beyond n are redundant
         */

        //left rotate by 1 place
//        leftRotation(arr, size);

        // left rotate by k places
//        leftRotationByK(arr, size, k);

        //right rotate by 1 place
//        rightRotation(arr, size);

        //right rotate by k places
        rightRotationByk(arr, size, k);
    }

    public static void leftRotation(int[] arr, int size){

        int temp = arr[0];
        for(int i = 1; i< size; i++){
            arr[i-1] = arr[i];
        }
        arr[size -1] = temp;

        System.out.println("Left rotate");
        for(int i = 0; i<size; i++){
            System.out.println(arr[i] + " ");
        }
    }

    public static void leftRotationByK(int[] arr, int size, int k){
        k = k % size;

        //first copy the elements to temp
        int[] temp = new int[k];
        for(int i =0; i<k ; i++){
            temp[i] = arr[i];
        }

        //shifting remaining elements to left
        for(int i =k; i<size ; i++){
            arr[i-k] = arr[i];
        }

        //putting temp element to arr to end

        for(int i=0; i<k; i++){
            arr[size-k + i] = temp[i];
        }

        System.out.println("Left Shifting elements by k places");
        for(int i = 0; i< size ; i++){
            System.out.println(arr[i] + " ");
        }

    }

    public static void rightRotation(int[] arr,int size){
        int temp = arr[size-1];
        for(int i = size -2; i>=0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = temp;
        System.out.println("Right rotate");
        for(int i = 0; i<size ; i++){
            System.out.println(arr[i] + " ");
        }
    }

    public static void rightRotationByk(int[] arr, int size, int k){
        k = k % size;

        //first copy the last elements to temp arr
        int[] temp = new int[k];
        for(int i = 0; i<k; i++){
            temp[i] = arr[(size-k)+i];
        }

        // shift remaining elements to the right
        for (int i = size - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }

        //copy temp elements back to array
        for(int i = 0; i<k; i++){
            arr[i] = temp[i];
        }

        System.out.println("Right Shifting elements by k places");
        for(int i = 0; i< size ; i++){
            System.out.println(arr[i] + " ");
        }
    }
}
