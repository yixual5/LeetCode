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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    private ListNode getMid(ListNode head) {
        ListNode mid = null;
        while (head != null && head.next != null) {
            mid = (mid == null) ? head : mid.next;
            head = head.next.next;
        }
        // mid belong to first half
        ListNode result = mid.next;
        mid.next = null;
        return result;
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pointer.next = node1;
                node1 = node1.next;
            } else {
                pointer.next = node2;
                node2 = node2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = (node1 != null) ? node1 : node2;
        return head.next;
    }
}


//iterative merger sort, O(1) space
class Solution {
    private ListNode tail;

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        int n = getSize(head);
        ListNode start = head;
        for (int i = 1; i < n; i *= 2) {
            tail = dummy;
            while (start != null) {
                
                if (start.next == null) {
                    tail.next = start;
                    break;
                }
                ListNode[] temp = split(start, i);
                merge(start, temp[0]);
                start = temp[1];
            }
            start = dummy.next;
        }
        
        return dummy.next;
    }
    
    private ListNode[] split(ListNode head, int size) {
        ListNode mid = head;
        ListNode end = head.next;
        for (int i = 1; i < size; i++) {
            if (end.next != null) end = end.next.next != null ? end.next.next : end.next;

            if (mid.next != null) mid = mid.next;

        }
        
        // mid belong to first half
        ListNode result = mid.next;
        mid.next = null;
        ListNode newStart = end.next;
        end.next = null;
        return new ListNode[] {result, newStart};
    }
    
    private void merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pointer.next = node1;
                node1 = node1.next;
            } else {
                pointer.next = node2;
                node2 = node2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = (node1 != null) ? node1 : node2;
        //connect previous tail to merged list
        tail.next = head.next;
        while (pointer.next != null) pointer = pointer.next;
        //set newTail
        tail = pointer;
    }
    
    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
