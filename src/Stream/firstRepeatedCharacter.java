package Stream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class firstRepeatedCharacter {
    public static void main(String[] args) {

        String s = "Java articles are good";

        Map<Character, Long> map = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                Collectors.counting()));

        System.out.println(map);

        char  c= map.entrySet().stream().filter(e-> e.getValue()>1).findFirst().get().getKey();
        System.out.println(c);
    }
}
