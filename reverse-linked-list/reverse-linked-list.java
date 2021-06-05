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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            head.next.next = head;
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }
        ListNode prev = null;
        ListNode nxt = null;
        if (head.next != null && head.next.next != null) {
            prev = head;
            
            head = head.next;
            prev.next = null;
            nxt = head.next;
        }
        while (head.next != null && head.next.next != null) {
            head.next = prev;
            prev = head;
            head = nxt;
            nxt = head.next;
            
        }
        head.next = prev;
        nxt.next = head;
        head = nxt;
        return head;
    }
}