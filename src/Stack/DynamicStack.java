package Stack;

public class DynamicStack extends CustomStack {
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        //this takes care of when stack is full
        if (this.isFull()) {
            int[] temp = new int[data.length * 2];
            //copy all previous items into new data array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;

        }

        //at this point , array is not full
        //insert item
        return super.push(item);
    }
}
