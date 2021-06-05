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
        
        ListNode larger = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode cur = head;
        ListNode largerHead = larger;
        ListNode smallerHead = smaller;
        while (cur != null) {
            if (cur.val >= x) {

                larger.next = cur;
                larger = larger.next;
                
            } else {
                smaller.next = cur;
                smaller = smaller.next;
            }
            cur = cur.next;
        }
        larger.next = null;
        smaller.next = largerHead.next;
        
        return smallerHead.next;
    }
}
