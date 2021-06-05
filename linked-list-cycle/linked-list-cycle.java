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
        ListNode faster = head.next;
        while (faster != null && faster.next != null) {
            if (faster == slower) return true;
            faster = faster.next.next;
            slower = slower.next;
            
        }
        return false;
    }
}
