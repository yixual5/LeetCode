/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// same idea as maximun depth of binary tree
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        
        int maxl = 0;
        for (Node n: root.children) {
            maxl = Math.max(maxDepth(n), maxl);
        }
        
        return maxl + 1;
    }
}
