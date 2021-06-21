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
    int count = 0;
    
    public int goodNodes(TreeNode root) {
        if (root == null) return count;
        dfs(root, root.val);
        return count;
        
        
    }
    
    private void dfs(TreeNode root, int prev) {
        if (root == null) return;
        if (root.val >= prev) {
            count++;
            prev = root.val;
        }
        dfs(root.left, prev);
        dfs(root.right, prev);
    }
}