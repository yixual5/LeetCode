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
//O(kn) 30 mins
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        int idx = 0;
        
        
        while (true) {
            boolean temp = false;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        idx = i;
                        min = lists[i].val;
                    }
                    temp = true;
                }
            }
            if (temp) {
                pointer.next = new ListNode(min);
                pointer = pointer.next;
                lists[idx] = lists[idx].next;
            } else {
                break;
            }
        }
        return dummy.next;
    }
}

//minheap O(nlogk)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a1,a2) -> a1.val - a2.val);
        for (ListNode l : lists) {
            if (l != null) {
                q.offer(l);
            }
        }
        while (!q.isEmpty()) {
            ListNode temp = q.poll();
            pointer.next = new ListNode(temp.val);
            temp = temp.next;
            pointer = pointer.next;
            if (temp != null) q.offer(temp);
        }
        return dummy.next;
    }
}

//divide and conquer (will complete later)
