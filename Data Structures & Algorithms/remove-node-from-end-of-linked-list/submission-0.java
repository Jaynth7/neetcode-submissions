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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Dummy Node in case if we have to delete the head
        ListNode dummy = new ListNode(0 , head);
        ListNode left = dummy;
        ListNode right = head;
        

        //Think of it like a race.Where two cars maintain a distance of X meters.
        //Till the end , if both cars travel the same speed , they'll maintain the same distance
        //We implementing the same.
        //left would skip the nth node in this instance.
        while(n > 0){
            right = right.next;
            n--;
        }

        //Left node will stop just before the Nth Node.
        while(right != null){
            left = left.next;
            right = right.next;
        }

        //We would be directly skipping the nth node
        left.next = left.next.next;

        return dummy.next;
        
    }
}
