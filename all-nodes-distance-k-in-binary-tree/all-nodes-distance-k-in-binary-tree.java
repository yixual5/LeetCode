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
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null) return result;
        
        constructGraph(root, graph);
        dfs(target.val, 0, k, result);
        return result;
    }
    
    private void dfs(int curNode, int dis, int k, List<Integer> result) {
        visited.add(curNode);
        if (dis == k) {
            result.add(curNode);
            return;
        }
        dis++;
        for (Integer i : graph.getOrDefault(curNode, new ArrayList<>())) {
            
            if (visited.contains(i)) continue;
            dfs(i, dis, k, result);
            
        }
    }
    
    private void constructGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null) return;
        
        if (root.left != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
            constructGraph(root.left, graph);
        }
        if (root.right != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
            constructGraph(root.right, graph);
        }
        
        
    }
}