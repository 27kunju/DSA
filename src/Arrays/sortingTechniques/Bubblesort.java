package Arrays.sortingTechniques;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = {4,1,3,26,2,90};
        bubbleSort(arr);
//        optimizedBubbleSort(arr);

    }

    public static void bubbleSort(int[] arr){
        for(int i = 0; i< arr.length ; i++){
            for(int j= 0; j<arr.length -1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int x: arr){
            System.out.println(x + " ");
        }
    }

    public static void optimizedBubbleSort(int[] arr){
        int n = arr.length;
        for(int i =0; i<n;i++){
            boolean swapped = false;
            for(int j = 0; i< n-1; i++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        for(int x: arr){
            System.out.println(x + " ");
        }
    }

}
