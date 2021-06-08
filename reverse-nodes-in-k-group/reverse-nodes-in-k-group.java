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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode cur = head;
        
        ListNode newtail = null;
        ListNode prev = null;
        ListNode newHead = null;
        ListNode left = null;
        while (cur != null) {
            ListNode temptail = cur;
            
            int count = 0;
            
            while (count < k && cur != null) {
                count++;
                cur = cur.next;
            }
            
            if (count == k) {
                
                ListNode temp = reverseK(temptail, k);
            
                if (newHead == null) {
                    newHead = temp;
                }
                
                if (newtail != null) {
                    newtail.next = temp;
                }
                
                newtail = temptail;
                left = cur;
            }
            
            
        }
        if (newtail != null) {
            newtail.next = left;
        }
        
        return newHead == null ? head: newHead;
       
    }
    
    private ListNode reverseK(ListNode head, int k) {
        ListNode cur = head;
        ListNode prev = null;
        while (k != 0) {
            k--;
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    
}