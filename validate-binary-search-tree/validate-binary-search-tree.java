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
    int low;
    int high;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long low, long high) {
        if (root == null) return true;
        return low < root.val && root.val < high && dfs(root.left, low, root.val) &&
            dfs(root.right, root.val, high);
        
    }
}