package TwoPointers;

public class successfulPairsMain {
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        int success = 7;
        int[] res = successfulPairs(spells,potions,success);

        for(int n : res){
            System.out.println(n);
        }

    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {

        int[] res = new int[spells.length];

        for(int i =0; i<spells.length;i++){
            int count = 0;

            for(int j = 0; j<potions.length; j++){
                int product = spells[i]*potions[j];

                if(product >= success){
                    count++;
                    
                }

            }



            res[i] = count;
        }

        return res;


    }
}
