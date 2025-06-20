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


        //left rotate by 1 place
        leftRotation(arr, size);

        //right rotate by 1 place
        rightRotation(arr, size);
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

    public static void rightRotation(int[] arr,int size){
        int temp = arr[size-1];
        for(int i = size -1; i>=0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = temp;
        System.out.println("Right rotate");
        for(int i = 0; i<size ; i++){
            System.out.println(arr[i] + " ");
        }
    }
}
