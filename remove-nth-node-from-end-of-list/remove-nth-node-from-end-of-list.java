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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        int half = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            half++;
        }
        ListNode temp = head;
        if (fast == null) {
            if (n == half * 2) {
                head = head.next;
                return head;
            }
            if (half > n) {
                while (half - n > 1) {
                    slow = slow.next;
                    n++;
                }
                slow.next = slow.next.next;
                return head;
            } else if (half < n) {
                while (2 * half - 1 - n > 0) {
                    temp = temp.next;
                    n++;
                }
                temp.next = temp.next.next;
                return head;
            } else {
                while (half > 1) {
                    temp = temp.next;
                    half--;
                }
                temp.next = temp.next.next;
                return head;
            }
        } else {
            if (n == half * 2 + 1) {
                head = head.next;
                return head;
            }
            if (half + 1 > n) {
                while (half - n > 0) {
                    slow = slow.next;
                    n++;
                }
                slow.next = slow.next.next;
                return head;
            } else if (half + 1 < n) {
                while (2 * half - n > 0) {
                    temp = temp.next;
                    n++;
                }
                temp.next = temp.next.next;
                return head;
            } else {
                while (half > 1) {
                    temp = temp.next;
                    half--;
                }
                temp.next = temp.next.next;
                return head;
            }
        }
    }
}