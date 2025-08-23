package Arrays;

public class ArrayInsertion {

    public static void main(String[] args) {
        int[] arr = new int[10]; // fixed array of size 10
        arr[0] = 5;
        arr[1] = 7;
        arr[2] = 13;
        arr[3] = 17;
        arr[4] = 19;

        int size = 5;  // current size (no. of filled elements)
        int k = 2;     // position to insert

        // insert at end
        size = insertAtEnd(arr, size, 25);
        System.out.println("Insert at end");
        printArray(arr, size);

        // insert at start
        size = insertAtStart(arr, size, 3);
        System.out.println("Insert at start");
        printArray(arr, size);

        // insert at kth position
        size = insertAtPosition(arr, size, k, 99);
        System.out.println("Insert at position " + k);
        printArray(arr, size);
    }

    // Insert at end
    public static int insertAtEnd(int[] arr, int size, int value) {
        if (size >= arr.length) {
            System.out.println("Array is full! Cannot insert");
            return size;
        }
        arr[size] = value;
        return ++size;
    }

    // Insert at start
    public static int insertAtStart(int[] arr, int size, int value) {
        if (size >= arr.length) {
            System.out.println("Array is full! Cannot insert");
            return size;
        }
        // shift right
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = value;
        return ++size;
    }

    // Insert at given position (0-based index)
    public static int insertAtPosition(int[] arr, int size, int pos, int value) {
        if (size >= arr.length) {
            System.out.println("Array is full! Cannot insert");
            return size;
        }
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position!");
            return size;
        }
        // shift right from pos onwards
        for (int i = size - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = value;
        return ++size;
    }

    // Print array
    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
