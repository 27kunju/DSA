package Arrays;

public class ArrayDeletion {

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 5;
        arr[1] = 7;
        arr[2] = 13;
        arr[3] = 17;
        arr[4] = 19;

        int size = 5;
        int k = 3;

        //delete at end
        size = deleteAtEnd(arr, size);
        System.out.println("Delete at end");
        printArray(arr, size);

        //delete at start
        size = deleteAtStart(arr, size);
        System.out.println("Delete at start");
        printArray(arr, size);

        //delete at kth position
        size = deleteAtPosition(arr, size, k);
        System.out.println("Delete at position");
        printArray(arr, size);
    }

    public static int deleteAtEnd(int[] arr , int size){
        return --size;
    }

    public static int deleteAtStart(int[] arr, int size){
        for(int i =1 ; i< size ; i++){
            arr[i -1] = arr[i];
        }


        return --size;
    }

    public static int deleteAtPosition(int[] arr , int size, int k){
        if( k <0 || k >= size ){
            System.out.println("Invalid position");
            return size;
        }
        for(int i = k+1; i< size; i++){
            arr[i-1] = arr[i];
        }
        return --size;
    }

    public static void printArray(int[] arr, int size){
        for(int i = 0; i<size; i++){
            System.out.println(arr[i] +  " ");
        }
    }
}
