package Stack;

public class StackMain {
    public static void main(String[] args) throws StackException {
        CustomStack stack = new CustomStack(5);
        CustomStack stack2 = new CustomStack();
        stack2.push(4);
        stack2.push(5);
        stack2.push(7);
        stack2.push(8);

        System.out.println(stack2.pop());
    }
}
