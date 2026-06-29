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
    public void reorderList(ListNode head) {
        //Using the approach of fast and slow pointers

        ListNode fast = head;
        ListNode slow = head;


        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //The condition is in place so that we stop right before the null point

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        //These operations are set up ensure that a limit is in place when reordering 
        //prev pointer will start iterating from the last node , there has to be a point of limit 

        //whenever curr becomes null , it indicates that the order in which the second half of the list is reversed 
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            //When this operation is first run , it builds a trail of nodes that point to the opposite direction while not breaking the linked list
        }


        ListNode first = head;
        ListNode second = prev;
        //By now prev would have started to hold the address of the last node

        //Regardless of size , the node after the middle node will always point to null as it is the first node in the seperated list
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            //Saving the nodes after first and second such that first and second and freely point manipulate their points to point to a specific node to construct the reordered list


            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;

            //Updating the next pointer in first and second and moving forward
        }
    
    }
}
