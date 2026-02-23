package greedy;

public class canPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int l = flowerbed.length;

        if(n == 0) return true;

        for(int i = 0;i<l;i++){
            if(flowerbed[i] == 0){
                boolean leftEmpty = (i==0) ||(flowerbed[i-1]==0);
                boolean rightEmpty = (i==l-1) || flowerbed[i+1] == 0;

                if(leftEmpty && rightEmpty){
                    flowerbed[i] =1;
                    n--;
                    if(n==0) return true;
                }
            }
        }

        return false;


    }
}
