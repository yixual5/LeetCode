/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuffer sb = new StringBuffer();
    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            sb.append("null,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        return helper(temp);
    }
    
    private TreeNode helper(String[] temp) {
        if (idx >= temp.length) {
            return null;
        }
        if (temp[idx].equals("null")) {
            idx++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(temp[idx++]));
        root.left = helper(temp);
        root.right = helper(temp);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));