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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-101);
        ListNode temp = root;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                root.next = l1;
                l1 = l1.next;
            } else {
                root.next = l2;
                l2 = l2.next;
            }
            root = root.next;
        }
        if (l1 != null) {
            root.next = l1;
        } else {
            root.next = l2;
        }
        return temp.next;
    }
}