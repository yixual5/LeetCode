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
        ListNode hed = dummy;
        int res = 0;
        while (l1 != null || l2 != null) {
            int l1v = l1 == null ? 0 : l1.val;
            int l2v = l2 == null ? 0 : l2.val;
            int sum = l1v + l2v;
            if (res > 0) {
                sum++;
            }
            res = sum / 10;
            sum = sum % 10;
            hed.next = new ListNode(sum);
            hed = hed.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
   
        if (res > 0) hed.next = new ListNode(1);
        return dummy.next;
    }
}