/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        return partition(lists,0,lists.length-1);
    }
    private ListNode partition(ListNode[] lists,int start,int end) {
        if(start==end) {
            return lists[start];
        }
        else if(start<end) {
            int mid = start + (end-start)/2;
            ListNode l1 = partition(lists,start,mid);
            ListNode l2 = partition(lists,mid+1,end);
            return merge(l1,l2);
        }
        else {
            return null;
        }
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
    /*
        if(lists==null || lists.length==0) {
            return null;
        }
        
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListComparator());
        
        for(ListNode node : lists) {
            if(node!=null) {
                queue.offer(node);
            }
        }
        
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            temp.next = node;
            temp = temp.next;
            
            if(node.next!=null) {
                queue.offer(node.next);
            }
        }
        
        return newNode.next;
    }
    
    class ListComparator implements Comparator {
        @Override
        public int compare(Object o1,Object o2) {
            ListNode l1 = (ListNode)o1;
            ListNode l2 = (ListNode)o2;
            
            return l1.val-l2.val;
        }
    }
    */
}