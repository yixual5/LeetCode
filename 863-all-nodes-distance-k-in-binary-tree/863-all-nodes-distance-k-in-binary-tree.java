/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return res;
        findTarget(root, target, k);
        return res;
        
    }
    
    public int findTarget(TreeNode root, TreeNode target, int k) {
        if (root == null) return -1;
        if (root.val == target.val) {
            dfs(root, 0, k);
            return 1;
        }
        int left = findTarget(root.left, target, k);
        // find left
        if (left != -1) {
            if (left == k) res.add(root.val);
            if (left < k) {
                // already from left, only need to look right
                // and pass distance back to parent
                dfs(root.right, left + 1, k);
            }
            return left + 1;
        }
        int right = findTarget(root.right, target, k);
        // find right
        if (right != -1) {
            if (right == k) res.add(root.val);
            if (right < k) {
                // already from right, only need to look left
                // and pass distance back to parent
                dfs(root.left, right + 1, k);
            }
            return right + 1;
        }
        // not find
        return -1;
    }
    
    public void dfs(TreeNode root, int dis, int k) {
        if (root == null) return;
        if (dis == k) {
            res.add(root.val);
            return;
        }
        dfs(root.left, dis + 1, k);
        dfs(root.right, dis + 1, k);
    }
    
}