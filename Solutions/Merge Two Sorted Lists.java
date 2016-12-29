/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        else if(l2==null) {
            return l1;
        }
        else if(l1.val<l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    /*
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        while(l1!=null && l2!=null) {
            if(l1.val<=l2.val) {
                temp.next = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while(l1!=null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2!=null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        temp.next = null;
        return l3.next;
    }
    */
}