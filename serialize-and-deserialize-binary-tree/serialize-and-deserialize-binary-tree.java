/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// O(n), dfs preorder
public class Codec {
    StringBuffer sb = new StringBuffer();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        dfs(sb, root);
        return sb.toString();
        
    }
    
    private void dfs(StringBuffer sb, TreeNode root) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(',');
        dfs(sb, root.left);
        dfs(sb, root.right);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        int index[] = new int[]{-1};
        return helper(temp,index);
    }
    
    private TreeNode helper(String[] temp, int[] index) {
        index[0]++;
        
        if (index[0] >= temp.length) {
            return null;
        }
        if (temp[index[0]].equals("null")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(temp[index[0]]));
        root.left = helper(temp, index);
        root.right = helper(temp, index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
