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
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return count;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int left_count = 0;
        int right_count = 0;
        if (node.left != null) left_count += left + 1;
        if (node.right != null) right_count += right + 1;
        count = Math.max(count, left_count + right_count);
        return Math.max(left_count, right_count);
    }
}