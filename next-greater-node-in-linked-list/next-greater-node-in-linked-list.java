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
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[]{};
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        int[] result = new int[l.size()];
        //System.out.println(result[1]);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < l.size(); i++) {
            while (!s.isEmpty() && l.get(s.peek()) < l.get(i)) {
                result[s.pop()] = l.get(i);
            }
            s.push(i);
        }
        return result;
    }
}