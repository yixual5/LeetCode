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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        
        while (head != null && head.val == val) {
            head = head.next;
        }
        // safely to check next
        ListNode cur = head;
        
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                // not moving forward because we don't know if we need remove new cur.next
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
