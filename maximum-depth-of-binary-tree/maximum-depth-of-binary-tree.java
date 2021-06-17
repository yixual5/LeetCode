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
    private int mxdepth = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return mxdepth;
    }
    
    private void dfs(TreeNode root, int mlength) {
        mlength++;
        if (root.left == null && root.right == null) {
            mxdepth = Math.max(mlength, mxdepth);
            return;
        }
        
        if (root.left != null) {
            dfs(root.left, mlength);
        }
        if (root.right != null) {
            dfs(root.right, mlength);
        }
    }
}