/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        preOrder(root);
    }
    
    private TreeNode preOrder(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        TreeNode left = preOrder(node.left);
        TreeNode right = preOrder(node.right);
        
        if (left != null) {
            
            left.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        // return tail
        return right == null ? left : right;
    }
}