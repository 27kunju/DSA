package String;

public class ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for (String w : word1) s1.append(w);

        StringBuilder s2 = new StringBuilder();
        for (String w : word2) s2.append(w);

        return s1.toString().contentEquals(s2);
    }
}
