/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow_p = head;
        ListNode fast_p = head;
        while(fast_p!=null && fast_p.next!=null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if(slow_p==fast_p) {
                return true;
            }
        }
        return false;
    }
}