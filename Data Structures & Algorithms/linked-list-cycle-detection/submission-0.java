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
    public boolean hasCycle(ListNode head) {
        //By using fast and slow pointers

        ListNode fast = head;
        ListNode slow = head;

        // Loop continues as long as 'fast' can safely jump two nodes ahead.
        // This prevents a NullPointerException on 'fast.next.next'.
        while(fast != null && fast.next != null ){
            slow = slow.next;
            //increment by 1 steps
            fast = fast.next.next; 
            //increment by 2 steps

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
