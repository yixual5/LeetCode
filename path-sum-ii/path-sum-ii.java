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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<Integer> cur = new LinkedList<>();
        
        backtracking(root, targetSum, result, cur);
        return result;
    }
    
    private void backtracking(TreeNode root, int targetSum, List<List<Integer>> result,
                             LinkedList<Integer> cur) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            result.add((LinkedList) cur.clone());
            cur.removeLast();
            return;
        }
        //
        //cur.add(root.val);
        backtracking(root.left, targetSum - root.val, result, cur);
        backtracking(root.right, targetSum - root.val, result, cur);
        cur.removeLast();
    }
}
