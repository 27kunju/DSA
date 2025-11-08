package LinkedList;

public class addNumbersMain {

    public myNode addNumbers(myNode l1, myNode l2){

        myNode result = new myNode(-1);
        myNode ptr = result;

        int carry = 0;

        while( l1 != null || l2 != null){
            int sum = 0+carry;

            if(l1 != null){
                sum +=l1.data;
                l1 = l1.next;
            }

            if(l2 != null){
                sum +=l2.data;
                l2 = l2.next;
            }

            carry = sum /10;
            sum = sum % 10;
            ptr.next = new myNode(sum);
            ptr = ptr.next;

        }

        if(carry == 1)
            ptr.next = new myNode(1);

        return result.next;


    }
}
