/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    //There are few edge cases that very easy to miss
    //What if the no.of nodes in the list is not equal to each other
    //What if there is a carry after adding the values in the last nodes.
    
    //BTW , I could have just started adding the numbers wihout reversing it bcz we are starting from the 
    //lowest digit
    //Best approach - Iteration
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //To create the list
        ListNode dummy = new ListNode();
        ListNode curr = dummy;


        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            //Only assign the values if the last node is not null
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            //if it exceeds 9
            carry = val / 10;
            //if exceeds 9
            val %= 10;

            curr.next = new ListNode(val);
            

            //Move forward to next node

            curr = curr.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;

    }
}

/* Wrong Solution 

ListNode temp1 = l1;
        ListNode temp2 = l2;

        int n1 = 0;
        int n2 = 0;

        while(temp1 != null || temp2 != null){
            n1 = n1 * 10 + temp1.val;
            n2 = n2 * 10 + temp2.val;

            temp1 = temp1.next;
            temp2 = temp2.next;  
        }

        int a = reverse(n1);
        int b = reverse(n2);

        int result = a + b;
*/
