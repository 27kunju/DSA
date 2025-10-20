package LinkedList;


public class FindLength {

    public static int findLength(myNode head){
        int len = 0;
        myNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        return len;

    }

    public static void main(String[] args) {
        myNode head = new myNode(1);
        head.next = new myNode(2);
        head.next.next = new myNode(3);
        head.next.next.next= new myNode(4);
        System.out.println(findLength(head));
    }


}
