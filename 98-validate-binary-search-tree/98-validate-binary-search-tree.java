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
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        prev = root.val;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, Long left, Long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) return false;
        boolean l = true;
        boolean r = true;
        if (root.left != null) {
            l = dfs(root.left, left, (long) root.val);
        }
        if (root.right != null) {
            r = dfs(root.right, (long) root.val, right);
        }
        return l && r;
        
    }
}