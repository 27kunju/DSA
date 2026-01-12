package String;

public class StringBuilderAllMethodsDemo {

    public static void main(String[] args) {

        // 1️⃣ Constructors
        StringBuilder sb = new StringBuilder();           // default capacity = 16
        StringBuilder sb1 = new StringBuilder(30);        // custom capacity
        StringBuilder sb2 = new StringBuilder("Java");    // initialized with value

        System.out.println("Initial sb2: " + sb2);

        // 2️⃣ append()
        sb2.append(" Backend");
        sb2.append(" Engineer");
        sb2.append(2025);
        System.out.println("After append: " + sb2);

        // 3️⃣ insert()
        sb2.insert(4, " FullStack");
        System.out.println("After insert: " + sb2);

        // 4️⃣ replace()
        sb2.replace(0, 4, "JAVA");
        System.out.println("After replace: " + sb2);

        // 5️⃣ delete()
        sb2.delete(4, 14);
        System.out.println("After delete: " + sb2);

        // 6️⃣ deleteCharAt()
        sb2.deleteCharAt(4);
        System.out.println("After deleteCharAt: " + sb2);

        // 7️⃣ reverse()
        sb2.reverse();
        System.out.println("After reverse: " + sb2);

        // restore original order
        sb2.reverse();

        // 8️⃣ charAt()
        System.out.println("charAt(2): " + sb2.charAt(2));

        // 9️⃣ setCharAt()
        sb2.setCharAt(0, 'j');
        System.out.println("After setCharAt: " + sb2);

        // 🔟 length()
        System.out.println("Length: " + sb2.length());

        // 1️⃣1️⃣ capacity()
        System.out.println("Capacity: " + sb2.capacity());

        // 1️⃣2️⃣ ensureCapacity()
        sb2.ensureCapacity(50);
        System.out.println("Capacity after ensureCapacity: " + sb2.capacity());

        // 1️⃣3️⃣ substring()
        String sub1 = sb2.substring(0, 4);
        String sub2 = sb2.substring(5);
        System.out.println("Substring(0,4): " + sub1);
        System.out.println("Substring(5): " + sub2);

        // 1️⃣4️⃣ indexOf()
        System.out.println("IndexOf 'Backend': " + sb2.indexOf("Backend"));

        // 1️⃣5️⃣ lastIndexOf()
        System.out.println("LastIndexOf 'e': " + sb2.lastIndexOf("e"));

        // 1️⃣6️⃣ toString()
        String normalString = sb2.toString();
        System.out.println("Converted to String: " + normalString);

        // 1️⃣7️⃣ equals() behavior (IMPORTANT)
        StringBuilder sb3 = new StringBuilder("Java");
        StringBuilder sb4 = new StringBuilder("Java");
        System.out.println("sb3.equals(sb4): " + sb3.equals(sb4)); // false

        // Correct comparison
        System.out.println("Content equal: " + sb3.toString().equals(sb4.toString()));

        // 1️⃣8️⃣ trimToSize()
        sb2.trimToSize();
        System.out.println("Capacity after trimToSize: " + sb2.capacity());

        // 1️⃣9️⃣ chaining (very common)
        StringBuilder chain = new StringBuilder()
                .append("Hello")
                .append(" ")
                .append("World")
                .append("!");
        System.out.println("Chaining result: " + chain);

        // 2️⃣0️⃣ clear StringBuilder (interview trick)
        sb2.setLength(0);
        System.out.println("After clear, length: " + sb2.length());
        System.out.println("After clear, content: '" + sb2 + "'");








    }
}
