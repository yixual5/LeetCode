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

//top-down
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

//button-up
class Solution {
    
    
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        
        return dfs(root, root.val);
        
        
    }
    
    private int dfs(TreeNode root, int prev) {
        if (root == null) return 0;
        int result = prev <= root.val ? 1 : 0;
        result += dfs(root.left, Math.max(prev, root.val));
        result += dfs(root.right, Math.max(prev, root.val));
        return result;
    }
}
