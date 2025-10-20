package LinkedList;

class practiceLLImpl {
    private int size = 0;
    myNode head = null;

    public void addFirst(int val){
        myNode newNode = new myNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int val){
        myNode newNode = new myNode(val);

        if(head == null){
            head  = newNode;
        }

        myNode curr = head;
        while( curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;
        size++;
    }

    public void removeFirst(){
      if(head == null) return;
      head = head.next;
      size--;

    }

    public void removeLast(){
        if(head == null) return;

        if(head.next == null){
            head = null;
        }

        myNode curr = head;
        while(curr.next.next !=null){
            curr = curr.next;
        }

        curr.next = null;
        size = Math.max(0, size-1);

    }

    public void addAtPosition(int val , int pos) throws IndexOutOfBoundsException{
        try {
            if (pos > size || pos < 0) throw new IndexOutOfBoundsException("length is more");

            myNode newNode = new myNode(val);

            myNode curr = head;

            for (int i = 0; i < pos - 1; i++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
    }

    public void removeAtPosition(int pos){

        myNode curr = head;

        for(int i =0;i<pos-1;i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
        size--;
    }

    public boolean contains(int val){
        myNode curr = head;
        while(curr != null){
            if(curr.data == val){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int getSize(){
        return size;
    }

}


