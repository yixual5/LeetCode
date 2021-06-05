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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        if (left == right) return head;
        ListNode cur = head;
        ListNode lft = null;
        ListNode prev = null;
        ListNode acl = null;
        int count = 0;
        while (cur != null) {
            count++;
            if (count == left) {
                break;
            }
            prev = cur;
            cur = cur.next;
            
        }
        lft = prev;
        acl = cur;
        while (cur != null) {
            
            
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            count++;
            
            if (count == right) {
                temp = cur.next;
                cur.next = prev;
                acl.next = temp;
                if (lft != null){
                    lft.next = cur;
                    return head;
                } 
                return cur;
            }
        }
        return head;
    }
    
}