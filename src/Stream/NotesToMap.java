package Stream;

import java.util.*;
import java.util.stream.*;

import static java.util.Map.Entry.comparingByValue;

class Notes {
    String tagName;
    int tagId;

    public Notes(String tagName, int tagId) {
        this.tagName = tagName;
        this.tagId = tagId;
    }

    public String getTagName() { return tagName; }
    public int getTagId() { return tagId; }

    @Override
    public String toString() {
        return tagName + "=" + tagId;
    }
}

public class NotesToMap {
    public static void main(String[] args) {
        List<Notes> notes = Arrays.asList(
                new Notes("note1", 11),
                new Notes("note2", 22),
                new Notes("note3", 33),
                new Notes("note4", 44),
                new Notes("note5", 55),
                new Notes("note4", 66)   // duplicate key note4
        );

        Map<String, Integer> result = notes.stream()
                .collect(Collectors.toMap(
                        Notes::getTagName,
                        Notes::getTagId,
                        (e1,e2) -> e2, // keep latest value for duplicates
                        LinkedHashMap::new
                ));

        // Now sort by tagId descending
        Map<String, Integer> sortedResult = result.entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        LinkedHashMap::new
                ));

        System.out.println(sortedResult);
    }
}


/*


     Java Source Code (.java)
        ↓
     Java Compiler (javac)
        ↓
     Bytecode (.class)   ← Platform Independent
        ↓
     JVM (OS + CPU specific)
        ↓
     Native Machine Code





     C++ Source Code (.cpp)
        ↓
     C++ Compiler
        ↓
     Native Machine Code (.exe / binary)
        ↓
     OS + CPU


 */
