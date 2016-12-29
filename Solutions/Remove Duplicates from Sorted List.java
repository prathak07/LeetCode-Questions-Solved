/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while(temp2!=null) {
            if(temp1.val==temp2.val) {
                temp2 = temp2.next;
            }
            else {
                temp1.next = temp2;
                temp1 = temp2;
                temp2 = temp2.next;
            }
        }
        temp1.next = temp2;
        return head;
    }
}