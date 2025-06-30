package String;

import java.util.HashSet;
import java.util.Set;

public class numJewelsInStonesMain {
    public static void main(String[] args) {
        String jewels = "aAb", stones = "aAAbbbb";
        int count = numJewelsInStones(jewels , stones);

        System.out.println(count);
    }

    public static int numJewelsInStones(String jewels, String stones){
        Set<Character> jewelSet = new HashSet<>();
        for(char c : jewels.toCharArray()){
            jewelSet.add(c);
        }

        int count =0;

        for(char c: stones.toCharArray()){
            if(jewelSet.contains(c)){
                count++;
            }
        }

        return count;
    }
}
