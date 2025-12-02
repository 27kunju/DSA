package BinarySearch;

public class minimumShops {
    public boolean possibleToDistr(int[] quantities, int n , int mid){
        for( int p : quantities){
            n -= (p+mid-1)/mid;
            if(n<0) return false;
        }

        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;

        int l = 1;
        int r  = 0;

        for(int q : quantities){
            r = Math.max(r,q);
        }

        int res = 0;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(possibleToDistr(quantities,n,mid)){
                res= mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return res;

    }
}
