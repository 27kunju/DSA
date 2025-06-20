package Arrays;

public class InsertElement {
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] =  20;
        arr[2] = 5;
        arr[3] = 7;
        arr[4] = 15;

        int size = 5;
        int k = 3;

        //insert at end;
        size = insertAtEnd(arr, size, 19);
        System.out.println("Inserted element at end");
        printArray(arr, size);


        //insert at first
        size = insertAtFirst(arr, size, 24);
        System.out.println("Inserted at start");
        printArray(arr, size);


        //insert at k postion
        size  = insertAtPosition(arr, size, k, 14 );
        System.out.println("Inserted at kth position");
        printArray(arr, size);



    }

    public static int insertAtEnd(int[] arr , int size, int x){
        if(size >= arr.length){
            System.out.println("Array is full , cannot insert");
        }

        arr[size] = x;
        size++;
        return size;
    }

    public static int insertAtFirst(int[] arr, int size, int x){
        for(int i = size-1; i>=0 ; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = x;
        size++;
        return size;
    }

    public static int insertAtPosition(int[] arr, int size, int k , int x){
        if(size >= arr.length){
            System.out.println("Arrays is full");
        }

        for(int i = size -1; i >= k ; i--){
            arr[i+1] = arr[i];
        }

        arr[k] = x;
        size++;
        return size;
    }

    public static void printArray(int[] arr , int size){
        for(int i = 0; i< size ; i++){
            System.out.println(arr[i] + " ");
        }

    }

}
