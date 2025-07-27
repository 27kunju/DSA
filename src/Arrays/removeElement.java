package Arrays;

public class removeElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
         int size = removeelement(nums,val);
         System.out.println(size);
         for(int i = 0;i<size ; i++){
             System.out.print(nums[i]);
         }
    }

    public static int removeelement(int[] arr, int val){
        int i =0;
        int n = arr.length;
        for( int j = 0 ; j <n; j++){
            if(arr[j] != val){
                arr[i++] = arr[j];
            
            }
        }

        return i;
    }
}
