package LinkedList;

public class detectCycle2 {

    public myNode findStartNodeOfCycle(myNode head){
        //clearify this. if head is null what we should return sometimes null or head itself is returned
        if(head == null) return null;
        myNode slow = head;
        myNode fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
