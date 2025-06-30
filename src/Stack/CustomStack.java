package Stack;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE =10;

    int ptr = -1;

    /*
      usecase of this
      1.reference the object
      2. call constructor
     */
    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot pop from an empty stack");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }

    public int peek() throws  StackException{
        if(isEmpty()){
            throw new StackException("Stack is empty");
        }
        return data[ptr];
    }

    public boolean isFull(){
        return ptr == data.length -1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }
}
