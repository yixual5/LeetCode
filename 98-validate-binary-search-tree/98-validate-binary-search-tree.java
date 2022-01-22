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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, Long left, Long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) return false;
        return dfs(root.left, left, (long) root.val) && dfs(root.right, (long) root.val, right);
    }
}