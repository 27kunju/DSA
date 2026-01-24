package Arrays;

public class MoveNegativeToLeft {

    public static void main(String[] args) {
        int[] arr = {-6, 3, -8, 10, 5, -7, 9, 12, -4, 2};

        int i = 0, j = arr.length - 1;

        while (i < j) {

            while (i < j && arr[i] < 0) i++;
            while (i < j && arr[j] >= 0) j--;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
