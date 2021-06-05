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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while (pointer2 != null && pointer2.next != null) {
            pointer2 = pointer2.next.next;
            pointer1 = pointer1.next;
        }
        ListNode prev = null;
        //pointer1 = pointer1.next; pointer1 is at the beginning pf second half
        while (pointer1 != null) {
            ListNode temp = pointer1.next;
            pointer1.next = prev;
            prev = pointer1;
            pointer1 = temp;
        }
        ListNode cur = head;
        while (prev != null) {
            if (cur.val != prev.val) return false;
            cur = cur.next;
            prev = prev.next;
        }
        return true;
    }
}
