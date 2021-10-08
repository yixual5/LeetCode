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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, LinkedList<Integer>> col = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> temp = q.poll();
            TreeNode par = temp.getKey();
            int cols = temp.getValue();
            if (par != null) {
                min = Math.min(cols, min);
                max = Math.max(cols, max);
                col.computeIfAbsent(cols, k -> new LinkedList<Integer>()).addLast(par.val);
                q.offer(new Pair<>(par.left, cols - 1));
                q.offer(new Pair<>(par.right, cols + 1));
            }
            
        }
        for (int i = min; i <= max; i++) {
            res.add(col.get(i));
        }
        return res;
    }
}