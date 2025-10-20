package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class removeDuplicatesMain{

    //removing all duplicates from sorted list
    // 1 1 1 2 3  -> 2 3
    public myNode removeDuplicates2(myNode  head){
        if(head == null || head.next == null) return head;

        myNode dummy = new myNode(-1);
        dummy.next  = head;

        myNode prev = dummy;
        myNode curr = head;

        while(curr != null){

            if(curr.next != null && curr.data == curr.next.data){
               while(curr.next != null && curr.data == curr.next.data){
                   curr = curr.next;
               }
               prev.next = curr.next;
            }else{
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }

    // remove only duplicates in sorted LL, keep fist occurance
    // 1 1 2 2 3 4 4 -> 1 2 3 4
    public myNode removeDuplicates(myNode head){
        if(head == null) return head;

        myNode curr = head;
        while(curr.next != null){

            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }

        return head;
    }

    //remove dulicates in unsorted LL

    public myNode removeDuplicatesFromUnsortedLL(myNode head){
        if(head == null) return head;

        myNode dummy = new myNode(-1);
        dummy.next = head;
        myNode prev = dummy;
        myNode curr = head;
        Set<Integer> set = new HashSet<>();

        while(curr !=null){

            if(set.contains(curr.data)){
                prev.next = curr.next;
            }else{
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
