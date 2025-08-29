package Arrays;

public class unionArrays {

    public static void main(String[] args) {
        int[] A = {3, 5, 10, 4, 6};
        int[] B = {12, 4, 7, 2, 5};

        int[] res = new int[A.length + B.length];
        int size = 0;

        // Step 1: copy all elements of A
        for (int i = 0; i < A.length; i++) {
            res[size++] = A[i];
        }

        // Step 2: copy from B if not already present
        for (int j = 0; j < B.length; j++) {
            boolean found = false;
            for (int k = 0; k < size; k++) {
                if (res[k] == B[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                res[size++] = B[j];
            }
        }

        // Print union
        System.out.print("Union: ");
        for (int i = 0; i < size; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
