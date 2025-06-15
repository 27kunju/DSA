package HashMap;


import java.util.Iterator;

public class UseCustomMap {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Put values
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        map.put("banana", 25); // Update existing key

        // Get values
        System.out.println("apple: " + map.get("apple"));     // 10
        System.out.println("banana: " + map.get("banana"));   // 25
        System.out.println("grape: " + map.get("grape"));     // null

        // Contains key
        System.out.println("Contains 'orange'? " + map.containsKey("orange")); // true
        System.out.println("Contains 'grape'? " + map.containsKey("grape"));   // false

        // Remove a key
        System.out.println("Removing 'orange' → " + map.remove("orange"));
        System.out.println("After removing 'orange', contains? " + map.containsKey("orange"));

        // Size
        System.out.println("Size of map: " + map.size()); // 2

        // Iterate over keys
        System.out.println("Keys in map:");
        Iterator<String> it = map.keyIterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println("  " + key + " → " + map.get(key));
        }

        // Clear map
        map.clear();
        System.out.println("Map cleared. Size: " + map.size()); // 0


        //using customhashset

        CustomHashSet<String> sets = new CustomHashSet<>();
        sets.add("Dog");
        sets.add("cat");
        System.out.println("\nHashSet keys:");
        Iterator<String> setsIt = sets.iterator();
        while (setsIt.hasNext()) {
            String key = setsIt.next();
            System.out.println("  " + key);
        }
    }
}
