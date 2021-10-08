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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(map, 0, 0, root);
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> tm : map.values()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (PriorityQueue<Integer> q : tm.values()) {
                while (!q.isEmpty()) temp.addLast(q.poll());
                
            }
            res.add((List<Integer>) temp);
        }
        return res;
    }
    
    private void dfs(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int row, int col, TreeNode root) {
        if (root == null) return;
        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<Integer, PriorityQueue<Integer>>());
        }
        if (!map.get(col).containsKey(row)) {
            map.get(col).put(row, new PriorityQueue<Integer>());
        }
        map.get(col).get(row).offer(root.val);
        dfs(map, row + 1, col - 1, root.left);
        dfs(map, row + 1, col + 1, root.right);
    }
}