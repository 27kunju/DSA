package Arrays.sortingTechniques;

public class Insertsort {

    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4};
        insertionSort(arr);
        System.out.println("sorted");
        for(int x: arr){
            System.out.println(x + " ");
        }
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i<n ; i++){
            int j = i-1;
            int key = arr[i];
            while(j>-1 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
