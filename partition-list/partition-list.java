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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode larger = null;
        ListNode smaller = null;
        ListNode cur = head;
        ListNode largerHead = null;
        ListNode smallerHead = null;
        while (cur != null) {
            if (cur.val >= x) {
                if (larger == null) {
                    larger = cur;
                    largerHead = cur;
                } else {
                    larger.next = cur;
                    larger = larger.next;
                }
                
            } else {
                if (smaller == null) {
                    smaller = cur;
                    smallerHead = cur;
                } else {
                    smaller.next = cur;
                    smaller = smaller.next;
                }
            }
            cur = cur.next;
        }
        if (larger != null) larger.next = null;
        if (smaller != null) smaller.next = largerHead;
        
        return smallerHead == null ? largerHead : smallerHead;
    }
}