package LinkedList;

public class middleofLLmain {

    public static myNode findMidNode(myNode head){
        if(head == null){
            return null;
        }
        //find length l
        // travese l/2
        int length = FindLength.findLength(head);
        int n = length/2;
        myNode curr = head;

        while( n>0 && curr != null){
            curr = curr.next;
            n--;

        }

        return curr;
    }

    public static myNode findMidNode2(myNode head){
        myNode slow = head;
        myNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast =fast.next;
        }

        return slow;
    }
}
