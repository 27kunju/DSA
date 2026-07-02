package Interview.Guidewire;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class stringsMatch {

    //[toast, cheese, bread, breada]
    //[abheeecdsgh]

    public int recipesFromIngridents(String[] recipes, String s){

        Map<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int count = 0;

        for(String recipe : recipes){

            Map<Character,Integer> map2 = new HashMap<>();
            Set<Character> set = new HashSet<>();

            for(char ch : recipe.toCharArray()){

                map2.put(ch, map2.getOrDefault(ch,0)+1);
                set.add(ch);
            }

            int letterCount = 0;

            for(char ch : set){

                if(map.containsKey(ch) && map.get(ch) >= map2.get(ch)){
                    letterCount++;
                }

            }

            if(letterCount == set.size()){
                count++;
            }
        }

        return count;

    }

    public int recipesFromIngrients2(String[] recipes, String s){

        int[] available = new int[26];

        for(char ch : s.toCharArray()){

            available[ch -'a']++;
        }

        int count = 0;

        for(String recipe : recipes){

            int[] required = new int[26];

            for(char ch : recipe.toCharArray()){
                required[ch -'a']++;
            }

            boolean possible = true;

            for(char ch : recipe.toCharArray()){
                if(required[ch-'a'] > available[ch -'a']){
                    possible = false;
                    break;
                }
            }

            if(possible){
                count++;
            }
        }

        return count;
    }
}
