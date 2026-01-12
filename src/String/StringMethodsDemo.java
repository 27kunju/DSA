package String;

public class StringMethodsDemo {

    public static void main(String[] args) {

        // 1️⃣ substring() - Java 7+ behavior
        String s = "HelloWorld";
        String sub = s.substring(5);
        System.out.println("substring: " + sub); // World


        // 2️⃣ indexOf() & lastIndexOf()
        String s2 = "java developer java";
        System.out.println("indexOf java: " + s2.indexOf("java"));       // 0
        System.out.println("lastIndexOf java: " + s2.lastIndexOf("java"));// 15


        // 3️⃣ split()
        String fruits = "apple,banana,orange";
        String[] fruitArr = fruits.split(",");

        System.out.print("split: ");
        for (String fruit : fruitArr) {
            System.out.print(fruit + " ");
        }
        System.out.println();


        // 4️⃣ replace() & replaceAll()
        String mixed = "abc123xyz";
        System.out.println("replace: " + mixed.replace("abc", "###"));
        System.out.println("replaceAll: " + mixed.replaceAll("[0-9]", "*"));


        // 5️⃣ trim() & strip() (Java 11+)
        String spaced = "   hello   ";
        System.out.println("trim: '" + spaced.trim() + "'");
        System.out.println("strip: '" + spaced.strip() + "'");


        // 6️⃣ startsWith() & endsWith()
        String fileName = "java_developer.txt";
        System.out.println("startsWith java: " + fileName.startsWith("java"));
        System.out.println("endsWith .txt: " + fileName.endsWith(".txt"));
        System.out.println("endsWith .pdf: " + fileName.endsWith(".pdf"));


        // 7️⃣ toCharArray()
        String word = "java";
        char[] chars = word.toCharArray();

        System.out.print("toCharArray: ");
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}

