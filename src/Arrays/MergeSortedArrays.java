package Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr  = {1,2,3,4,5};
        int[] arr2  = {6,7,8,9};
        int[] merge  = new int[arr.length + arr2.length];
        int i  =0;
        int j  =0;
        int k = 0;
        int m = arr.length, n = arr2.length;
        while( i<m && j<n){
            if(arr[i] < arr2[j]){
                merge[k++] = arr[i++];
            } else {
                merge[k++] = arr2[j++];
            }

        }

        for( ; i<m ; i++){
            merge[k++] = arr[i];
        }

        for( ; j<n; j++){
            merge[k++]  = arr2[j];
        }

        for(int x: merge){
            System.out.println(x + " ");
        }

    }
}
