package Stack;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> input;
    private Stack<Integer> output;

    private int peekElement;

    public QueueUsingStack(){
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x){
        if(input.isEmpty()){
            peekElement = x;
        }
        input.push(x);

    }

    public int pop(){

        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek(){
        if(output.isEmpty()){
            return peekElement;
        }
        return output.peek();
    }

    public boolean isEmpty(){
        return input.isEmpty() && output.isEmpty();
    }

}

/*


 ✅ Notes for This Queue Using Two Stacks (with peek optimization)

input stack stores newly pushed elements, and output is used only when popping/peeking.

When pushing, if input is empty, store the value in peekElement so we always know the front of the queue.

When popping, transfer all elements from input → output only when output is empty (lazy transfer).

peek() returns peekElement when output is empty—this avoids moving elements just to peek.

output.peek() is used when output has elements, since its top is the actual queue front.

Queue is empty only if both stacks are empty.

Time complexity remains amortized O(1) for push/pop/peek.

Amortized O(1) Summary

The queue achieves amortized O(1) time because each element is moved a limited number of times.

Push is always O(1) since new elements are simply pushed onto the input stack.

Pop is usually O(1) when elements already exist in the output stack.

Pop is occasionally O(n) only when output is empty and all elements must be transferred from input to output.

Each element is transferred at most once, so the total cost of these expensive transfers is spread across many cheap operations.

Because the infrequent O(n) transfers are balanced by many O(1) pushes and pops, the average cost per operation is O(1) — which is amortized O(1).
 */