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
    List<Integer> result = new ArrayList<>();
    int left;
    int level;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) throw new IllegalArgumentException();
        this.left = root.val;
        this.level = 0;
        dfs(root, 0);
        return this.left;
        
    }
    
    private void dfs(TreeNode root, int curlevel) {
        
        if (root == null) return;
        curlevel++;
        if (root != null && (root.left != null || root.right != null) && curlevel > this.level) {
            left = root.left == null ? root.right.val : root.left.val;
            this.level = curlevel;
        }
        
        dfs(root.left, curlevel);
        
        dfs(root.right, curlevel);
        
    }
}


// cleaner solution
class Solution {
    List<Integer> result = new ArrayList<>();
    int left;
    int level;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) throw new IllegalArgumentException();
        this.left = root.val;
        this.level = 0;
        dfs(root, 0);
        return this.left;
        
    }
    
    private void dfs(TreeNode root, int curlevel) {
        
        if (root == null) return;
        curlevel++;
        if (curlevel > level) {
            this.left = root.val;
            this.level = curlevel;
        }
        
        dfs(root.left, curlevel);
        
        dfs(root.right, curlevel);
        
    }
}
