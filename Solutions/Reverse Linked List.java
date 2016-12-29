/*
Reverse a singly linked list.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    /*
    public ListNode reverseList(ListNode head) {
        return helper(head,null);
    }
    private ListNode helper(ListNode head,ListNode prev) {
        if(head==null) {
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        return helper(next,head);
    }
    */
}