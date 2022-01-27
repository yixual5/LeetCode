/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuffer sb = new StringBuffer();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(Node root, StringBuffer sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        int sz = root.children != null ? root.children.size() : 0;
        sb.append(root.val).append("#").append(sz).append(",");
        for (int i = 0; i < sz; i++) {
            serializeHelper(root.children.get(i), sb);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        List<String> dt = new LinkedList<>();
        dt.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(dt);
    }
    
    private Node deserializeHelper(List<String> data) {
        if (data.size() == 0 || data.get(0).equals("null")) return null;
        String[] temp = data.remove(0).split("#");
        Node root = new Node(Integer.valueOf(temp[0]));
        List<Node> children = new LinkedList<>();
        int sz = Integer.valueOf(temp[1]);
        for (int i = 0; i < sz; i++) {
            children.add(deserializeHelper(data));
        }
        root.children = children;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));