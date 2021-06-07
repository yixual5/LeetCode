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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode dummy = new ListNode(-1,head);
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                prev.next = cur;
                prev = prev.next;
            } else {
                while (cur != null && cur.next != null && cur.val == cur.next.val ) {
                    cur = cur.next;
                }
            }
            
            cur = cur.next;
            
            
            
        }
        prev.next = cur;
        return dummy.next;
    }
}