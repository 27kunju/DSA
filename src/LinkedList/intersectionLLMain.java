package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class intersectionLLMain {

    //we are taking space set - O(n)
    public myNode interSectionNode(myNode head, myNode head2) {
        if (head == null || head2 == null) return null;

        Set<myNode> set = new HashSet<>();
        myNode curr = head;

        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }

        myNode curr2 = head2;
        while (curr2 != null) {
            if (set.contains(curr2)) {
                return curr2;
            }
            curr2 = curr2.next;
        }

        return null;
    }



    //reduce space complexity
    public myNode intserSections2(myNode headA,myNode headB){
        int lenA = FindLength.findLength(headA);
        int lenB = FindLength.findLength(headB);

        while(lenA > lenB){
          headA = headA.next;
          lenA--;
        }

        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        //now both are at same size
        while(headA != headB){
            headA = headA.next;
            headB= headB.next;
        }

        //headA and headB are pointing intersect node
        return headA;


    }

}
