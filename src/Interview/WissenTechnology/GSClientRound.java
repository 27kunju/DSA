package Interview.WissenTechnology;

import java.util.HashMap;
import java.util.Map;

class Pair{
    int i;
    int j;
    Pair(int i , int j){
        this.i = i;
        this.j = j;
    }
}
public class GSClientRound {
    public static void main(String[] args) {

    }

    public int[] longestUniqueSubstring(String s){

        Map<Integer,Pair> map = new HashMap<>();

        int i = 0, j= 0;
        int n = s.length();
        if(n<1) return new int[]{-1,0};
        int maxLength = 0;

        while(i<n){

            while(j<n && s.charAt(j) == s.charAt(i)){
                j++;
            }
            Pair pair = new Pair(i,j-i);
            map.putIfAbsent(i,pair);
            maxLength = Math.max(maxLength,j-i);

            i = j;


        }

        Pair pair1 = map.get(maxLength);

        return new int[]{pair1.i, pair1.j};


    }

    public int[] longestUniqueSubstring2(String s){

        int n = s.length();
        if(n<1) return new int[]{-1,0};

        int i = 0,j=0;
        int bestStart = 0, bestLength = 0;

        while(i<n){

            while(j<n && s.charAt(i) == s.charAt(j)){
                j++;
            }

            if(j-i>bestLength){
                bestLength = j-i;
                bestStart = i;
            }
            i=j;
        }

        return new int[]{bestStart,bestLength};
    }
}
