package LinkedList;

class myNode {
    int data;
    myNode next;

    public myNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class customLLImpl {
    private myNode head;
    private int size;

    public customLLImpl() {
        head = null;
        size = 0;
    }

    public void addFirst(int data) {
        myNode newNode = new myNode(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        myNode newNode = new myNode(data);
        if (head == null) {
            head = newNode;
        } else {
            myNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    public void insertAtPosition(int data, int position) {
        try {
            if (position < 0 || position > size) {
                throw new IndexOutOfBoundsException("Invalid position: " + position);
            }

            if (position == 0) {
                addFirst(data);
                return;
            }

            myNode newNode = new myNode(data);
            myNode curr = head;

            for (int i = 0; i < position - 1; i++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;
            size++;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void InsertRecurssion(int val , int index){

    }


    public void removeFirst() {
        if (head == null) {
            System.out.println("No data to delete");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            myNode current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public void removeAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position out of range: " + position);
        }

        if (position == 0) {
            removeFirst();
            return;
        }

        myNode current = head;
        int index = 0;

        while (index < position - 1) {
            current = current.next;
            index++;
        }

        current.next = current.next.next;
        size--;
    }

    public boolean contains(int data) {
        myNode current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        myNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}

public class CustomLinkedList{
    public static void main(String[] args) throws Exception {
        customLLImpl list = new customLLImpl();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.insertAtPosition(90, 10);  // now position is validated using size

        list.display();
        System.out.println("Size: " + list.getSize());
        System.out.println(list.contains(15));
    }
}
