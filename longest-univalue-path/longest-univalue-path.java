//o(N), 30 mins

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
    int ans = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        
        return Math.max(dfs(root), ans);
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int count_left = 0;
        int count_right = 0;
        if (node.left != null && node.left.val == node.val) {
            count_left += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            count_right += right + 1;
        }
        ans = Math.max(ans, count_left + count_right);
        return Math.max(count_left, count_right);
    }
}
