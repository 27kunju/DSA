package LinkedList;

public class reverseNodesBetweenMain {
    public static myNode reverseNodesBetween(myNode head, int left ,int right){

        if(head == null || left == right)
             return head;
        myNode dummy = new myNode(-1);
        dummy.next = head;

        myNode prev = dummy;

        for(int i =1;i<left;i++){
            prev = prev.next;
        }

        prev.next = reverse(prev.next,right-left+1);

        return dummy.next;



    }

    public static myNode reverse(myNode head, int k){

        if(head == null)
             return null;
        myNode prev = null;
        myNode curr = head;
        while(curr != null && k >0){
            myNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        head.next = curr;

        return prev;
    }

    public static void main(String[] args) {
        myNode head = new myNode(1);
        head.next = new myNode(2);
        head.next.next = new myNode(3);
        head.next.next.next= new myNode(4);

        reverseNodesBetween(head, 1,3);
    }
}
