package Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountStreamEle {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "orange", "apple", "orange");

        Map<String , Long> mapData = words.stream().collect(Collectors.groupingBy(e ->e , Collectors.counting()));
        System.out.println(mapData);

    }
}
