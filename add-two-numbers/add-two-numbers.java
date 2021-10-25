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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int remainder = 0;
        ListNode head = dummy;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2;
            if (remainder == 1) sum++;
            
            if (sum >= 10) {
                head.next = new ListNode(sum % 10);
                sum /= 10;
                remainder = 1;
            } else {
                head.next = new ListNode(sum);
                remainder = 0;
            }
            head = head.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (remainder == 1) head.next = new ListNode(1);
        return dummy.next;
    }
}