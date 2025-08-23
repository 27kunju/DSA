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

    // no need of extra arr to hold sorted elements from both array like above
    // here nums1 has enough space to hold both nums1 and nums2
    //therefore merge into nums1
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n -1;

        while( m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[last] = nums1[m-1];
                m--;
            }else{
                nums1[last] = nums2[n-1];
                n--;
            }

            last--;
        }

        while( n> 0){
            nums1[last] = nums2[n-1];
            n--;
            last--;
        }
    }
}
