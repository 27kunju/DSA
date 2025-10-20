package LinkedList;

public class reverseNodesBetweenMain {
    public myNode reverseNodesBetween(myNode head, int left ,int right){
        if(head == null || head.next == null) return head;

        myNode dummy = new myNode(-1);
        dummy.next = head;

        myNode leftPre = dummy;
        myNode currNode = head;

        for(int i =0; i<left-1;i++){
            leftPre = leftPre.next;
            currNode = currNode.next;
        }

        //since we work on currNode .save it
        myNode subListHead = currNode;
        myNode prev =null;
        //reverse sublist between left and right
        for(int i = 0;i<=right-left;i++){
            myNode next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        leftPre.next = prev;
        subListHead = currNode;

        return dummy.next;

    }
}
