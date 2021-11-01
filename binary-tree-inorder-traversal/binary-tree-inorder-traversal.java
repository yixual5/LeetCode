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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }
    
    private void dfs(TreeNode node, List<Integer> res) {
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        if (node.left != null) dfs(node.left, res);
        res.add(node.val);
        if (node.right != null) dfs(node.right, res);
    }
}