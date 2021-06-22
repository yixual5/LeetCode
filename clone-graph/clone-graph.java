/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        dfsCopy(node, visited);
        return visited.get(node.val);
    }
    
    private void dfsCopy(Node node, Map<Integer, Node> visited) {
        if (node == null) return;
        
        if (!visited.containsKey(node.val)) visited.put(node.val, new Node(node.val));
        
        for (Node n : node.neighbors) {
            if (visited.containsKey(n.val)) {
                Node temp = visited.get(n.val);
                visited.get(node.val).neighbors.add(temp);
                continue;
            }
            visited.put(n.val, new Node(n.val));
            Node temp = visited.get(n.val);
            visited.get(node.val).neighbors.add(temp);
            dfsCopy(n, visited);
        }
    }
}