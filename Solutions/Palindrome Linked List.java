/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) {
            return true;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        
        while(l1!=null && l2!=null) {
            if(l1.val!=l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
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
        if(head==null) {
            return true;
        }
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        
        while(temp!=null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        
        boolean result = false;
        while(!stack.isEmpty()) {
            int num = stack.pop();
            if(num==head.val) {
                result = true;
            }
            else {
                result = false;
                break;
            }
            head = head.next;
        }
        
        return result;
    }
    */
}