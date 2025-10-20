package LinkedList;

public class removeGivenNodeMain {

    public myNode removeGivenNode(myNode head, int val){

        myNode dummy = new myNode(-1);
        dummy.next = head;

        myNode curr = dummy;

        while(curr.next != null){
            if(curr.next.data == val){
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
