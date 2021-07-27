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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        int idx = 0;
        int min = Integer.MAX_VALUE;
        boolean fin = true;
        boolean temp = false;
        while (fin) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        idx = i;
                        min = lists[i].val;
                    }
                    temp = true;
                } else {
                    temp = temp || false;
                }
            }
            fin = temp;
            
            if (temp) {
                pointer.next = new ListNode(min);
                pointer = pointer.next;
                lists[idx] = lists[idx].next;
                temp = false;
                min = Integer.MAX_VALUE;
            } else {
                break;
            }
        }
        return dummy.next;
    }
}