package Arrays;

//sorted array
public class FindPairsForTargetMatch {
    public static void main(String[] args) {
        int[] arr = {3,4,5,5,6,7,8,12,14};
        int target = 11;

        int i =0 , j = arr.length-1;
        while(i<j){
            if(arr[i] + arr[j] == target){
                System.out.println("first element" + " " + arr[i] +"second element "+  "" +arr[j] + "traget"+  target);
                i++;
                j--;
            }else if(arr[i]+ arr[j]< target){
                i++;
            } else{
                j--;
            }
        }

    }
}
