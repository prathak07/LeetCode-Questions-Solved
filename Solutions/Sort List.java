/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head) {
        if(head==null || head.next==null) {
            return head;
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
        ListNode l = head;
        ListNode r = slow;
        
        ListNode hl = mergeSort(l);
        ListNode hr = mergeSort(r);
        
        head = merge(hl,hr);
        return head;
    }
    private ListNode merge(ListNode l1,ListNode l2) {
        if(l1==null) {
            return l2;
        }
        else if(l2==null) {
            return l1;
        }
        else if(l1.val<l2.val) {
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
    // public ListNode mergeSort(ListNode head) {
    //     if(head==null || head.next==null) {
    //         return head;
    //     }
    //     int count=0;
    //     ListNode temp = head;
    //     while(temp!=null) {
    //         count++;
    //         temp = temp.next;
    //     }
    //     int middle = count/2;
    //     ListNode l=head, r=null;
    //     temp = head;
    //     int countHalf=0;
    //     while(temp!=null) {
    //         countHalf++;
    //         if(countHalf==middle) {
    //             r = temp.next;
    //             temp.next = null;
    //         }
    //         temp = temp.next;
    //     }
        
    //     ListNode hl = mergeSort(l);
    //     ListNode hr = mergeSort(r);
        
    //     head = merge(hl,hr);
    //     return head;
        
    // }
    
    // public ListNode merge(ListNode l,ListNode r) {
    //     ListNode lt=l, rt=r;
    //     ListNode newList = new ListNode(0);
    //     ListNode temp = newList;
    //     while(lt!=null || rt!=null) {
    //         if(lt!=null && rt==null) {
    //             temp.next = lt;
    //             lt = lt.next;
    //         }
    //         else if(lt==null && rt!=null) {
    //             temp.next = rt;
    //             rt = rt.next;
    //         }
    //         else {
    //             if(lt.val<=rt.val) {
    //                 temp.next = lt;
    //                 lt = lt.next;
    //             }
    //             else {
    //                 temp.next = rt;
    //                 rt = rt.next;
    //             }
    //         }
    //         temp = temp.next;
    //     }
    //     return newList.next;
    // }
}