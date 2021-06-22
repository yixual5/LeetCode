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

//dfs
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        visited.put(node.val, new Node(node.val));
        dfsCopy(node, visited);
        return visited.get(node.val);
    }
    
    private void dfsCopy(Node node, Map<Integer, Node> visited) {
        if (node == null) return;
        
        for (Node n : node.neighbors) {
            if (!visited.containsKey(n.val)) {
                visited.put(n.val, new Node(n.val));
                
                dfsCopy(n, visited);
            }
            visited.get(node.val).neighbors.add(visited.get(n.val));
        }
    }
}

//cleaner dfs

class Solution {
    
    Map<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        if (visited.containsKey(node.val)) return visited.get(node.val);
        
        visited.put(node.val, new Node(node.val));
        
        for (Node n : node.neighbors) {
            visited.get(node.val).neighbors.add(cloneGraph(n));
        }
        return visited.get(node.val);
    }
    

}

//bfs

class Solution {
    
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited.put(node.val, new Node(node.val));
        while(!q.isEmpty()) {
            Node temp = q.poll();
            for (Node n : temp.neighbors) {
                if (!visited.containsKey(n.val)) {
                    visited.put(n.val, new Node(n.val));
                    q.offer(n);
                }
                visited.get(temp.val).neighbors.add(visited.get(n.val));
                
            }
        }
        return visited.get(node.val);
    }
    

}
