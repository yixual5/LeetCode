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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        StringBuffer sb = new StringBuffer();
        
        backtracking(result, sb, root);
        
        return result;
    }
    
    private void backtracking(List<String> result, StringBuffer sb, TreeNode root) {
        if (root == null) return;
        int lent = Integer.toString(root.val).length();
        sb.append(root.val + "->");
        if (root.left == null && root.right == null) {
            
            
            sb.setLength(sb.length() - 2);
            result.add(sb.toString());
            
            sb.setLength(sb.length() - lent);
            
            
            
            return;
        }
        
        
        backtracking(result, sb, root.left);
        backtracking(result, sb, root.right);

        sb.setLength(sb.length() - 2 - lent);
        
        
        
    }
}

//slightly faster and clearer version

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        StringBuffer sb = new StringBuffer();
        
        backtracking(result, sb, root);
        
        return result;
    }
    
    private void backtracking(List<String> result, StringBuffer sb, TreeNode root) {
        if (root == null) return;
        int lent = Integer.toString(root.val).length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            
            
            //sb.setLength(sb.length() - 2);
            result.add(sb.toString());
            
            sb.setLength(sb.length() - lent);
            
            
            
            return;
        }
        
        sb.append("->");
        backtracking(result, sb, root.left);
        //sb.setLength(sb.length() - 2);
        
        backtracking(result, sb, root.right);
        
        sb.setLength(sb.length() - lent - 2);
        
        
        
    }
}
