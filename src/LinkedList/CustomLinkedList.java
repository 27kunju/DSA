package LinkedList;

class myNode{
    int data;
    myNode  next;

    public myNode(int data){
        this.data = data;
        this.next = null;
    }
}

class customLLImpl{
    private myNode head;

    public customLLImpl(){
        head = null;
    }

    public void addFirst(int data){
        myNode newNode = new myNode(data);
        newNode.next = head;
        head  = newNode;
    }

    public void addLast(int data){
        myNode newNode = new myNode(data);

        if(head == null){
            head = newNode;
        }

        myNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.next = null;
    }

    public void add(int data, int position){
        myNode newNode  = new myNode(data);
        if(head == null){
            head = newNode;
        }

        if(position == 0){
            addFirst(data);
        }

        myNode curr = head;
        int index = 0;
        while(curr != null && index < position -1){
            curr = curr.next;
            index++;
        }
        if(curr == null){
            System.out.println("position out of range");
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;

    }

    public void removeFirst(){
        if(head == null){
            System.out.println("no data to delete");
            return;
        }
        head = head.next;
    }

    public void removeLast() {
        // Case 1: Empty list
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Case 2: Only one element
        if (head.next == null) {
            head = null;
            return;
        }

        // Case 3: More than one node
        myNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        // Remove last node
        current.next = null;
    }


    public void removeAtPosition(int position) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        // Case 1: Remove head
        if (position == 0) {
            head = head.next;
            return;
        }

        // Traverse to the node just before the one to remove
        myNode current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        // If position is out of bounds
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Position out of range");
        }

        // Remove node by skipping it
        current.next = current.next.next;
    }


    public boolean contains(int data){
        myNode current = head;
        while(current !=null){
            if( current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    public void display(){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        myNode curr = head;
        while(curr !=  null){
            System.out.println(curr.data + " ->");
            curr = curr.next;
        }
    }

}

public class CustomLinkedList {
    public static void main(String[] args) {
        customLLImpl  list = new customLLImpl();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.add(25,2);
        list.addFirst(5);
        list.display();

        list.removeFirst();
        list.display();

        list.removeAtPosition(3);
        list.display();

        list.removeLast();
        list.display();

        //searching for element
        System.out.println("is element present"+list.contains(20));
    }
}
