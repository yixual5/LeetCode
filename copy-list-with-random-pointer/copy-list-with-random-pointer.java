/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
            
        }
        
        Node cur2 = head;
        Node newH = cur2.next;
        //first think about unlink the old and new list when assign random poniter, but something wents wrong
        while (cur2 != null) {
            Node temp = cur2.next.next;
            cur2.next.random = cur2.random == null ? null : cur2.random.next;
            cur2 = temp;
        }
        // seperate two list
        Node old = head;
        Node new1 = head.next;
        Node newhead = head.next;
        while (old != null) {
            old.next = old.next.next;
            new1.next = old.next == null ? null : old.next.next;
            old = old.next;
            new1 = new1.next;
        
        }
        return newhead;
    }
}
