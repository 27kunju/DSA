package Stream;

public final class CounterSingleton {

    // Single instance
    private static final CounterSingleton instance = new CounterSingleton();

    private int count; // mutable state

    // Private constructor
    private CounterSingleton() {
        this.count = 0;
    }

    // Public access to singleton
    public static CounterSingleton getInstance() {
        return instance;
    }

    // Getter and Setter to mutate state
    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public static void main(String[] args) {
        CounterSingleton c1 = CounterSingleton.getInstance();
        CounterSingleton c2 = CounterSingleton.getInstance();

        System.out.println(c1.getCount()); // 0
        System.out.println(c2.getCount()); // 0

        // Mutate through c1
        c1.increment();

        System.out.println(c1.getCount()); // 1
        System.out.println(c2.getCount()); // 1

        // Both references see the same mutated state
        System.out.println(c1 == c2); // true
    }
}

