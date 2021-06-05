/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slower = head;
        ListNode faster = head;
        while (faster.next != null && faster.next.next != null) {
            
            faster = faster.next.next;
            slower = slower.next;
            if (faster.val == slower.val && faster.next == slower.next) return true;
        }
        return false;
    }
}