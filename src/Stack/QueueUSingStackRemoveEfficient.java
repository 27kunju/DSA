package Stack;

import java.util.Stack;

public class QueueUSingStackRemoveEfficient {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUSingStackRemoveEfficient(){
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(item);
        while(!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int peek() {
        return first.peek();
    }

}
