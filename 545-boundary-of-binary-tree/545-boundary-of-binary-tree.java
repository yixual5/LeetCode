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
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        if (root.left == null && root.right == null) return res;

        leftBoundary(root.left, res);
        addLeaves(root, res);
        rightBoundary(root.right, res);
        return res;
    }
    
    private void leftBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left == null) leftBoundary(root.right, res);
        else leftBoundary(root.left, res);
    }
    
    private void rightBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right == null) rightBoundary(root.left, res);
        else rightBoundary(root.right, res);
        res.add(root.val);
    }
    
    private void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }
}