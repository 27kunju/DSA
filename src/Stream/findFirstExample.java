package Stream;

import java.util.List;
import java.util.Arrays;

public class findFirstExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ashwini","tanuj", "manu", "giri", "acchut");

        System.out.println(names.stream().anyMatch(s -> s.startsWith("t")));

        System.out.println(names.stream().findFirst().get());

        System.out.println(names.stream().findAny().get());

        System.out.println(names.stream().allMatch(s ->s.length()>3));
    }
}
