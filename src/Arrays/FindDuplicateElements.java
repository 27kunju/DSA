package Arrays;

//finding duplicates in sorted array
public class FindDuplicateElements {
    public static void main(String[] args) {
        int[] arr  = {3,6,8,8,8,10,10, 12,15,15,15,20};
        int lastDuplicate = 0;
        for(int i =0; i<arr.length-1 ; i++){
            if(arr[i] == arr[i+1] && arr[i] !=lastDuplicate){
                System.out.println(arr[i]);
                lastDuplicate = arr[i];
            }
        }

    }
}
