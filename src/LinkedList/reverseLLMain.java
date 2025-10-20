package LinkedList;

public class reverseLLMain {

    public static myNode reverseLL(myNode head){
        myNode prev = null;

        while(head != null){
            myNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        myNode head = new myNode(1);
        head.next = new myNode(2);
        head.next.next = new myNode(3);
        head.next.next.next= new myNode(4);
        System.out.println(reverseLL(head));
    }
}
