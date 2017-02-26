/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode begin = dummy;
        
        int i=0;
        
        while(head!=null) {
            i++;
            if(i%k==0) {
                begin = reverse(begin,head.next);
                head = begin.next;
            }
            else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode begin,ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode next,first;
        first = curr;
        
        while(curr!=end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        first.next = curr;
        begin.next = prev;
        return first;
    }
}
