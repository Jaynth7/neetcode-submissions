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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0 , head);
        ListNode groupPrev = dummy;

        //The loop will only break if the number of nodes left is lesser than k
        while(true){
            ListNode kth = getKth(groupPrev, k);
            if(kth == null){
                break;
            }

            ListNode groupNext = kth.next;
            //Basically the last Node
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;

            while(curr != groupNext){
                //Keep on reversing
                ListNode temp = curr.next;

                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            //To store the first node
            //With the example of 1, 2 , 3 , 4, 5, ,6 -> 3 , 2 , 1 - groupPrev's next(dummy's next) is      pointing to 1 , we have to make it point to 3
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            // Move groupPrev to end of reversed group (1)
            groupPrev = tmp;
        }

        return dummy.next;
    }


    //Method used to return the kth node
    private ListNode getKth(ListNode curr , int k){
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
