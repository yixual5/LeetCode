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