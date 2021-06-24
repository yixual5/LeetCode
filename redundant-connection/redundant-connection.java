class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return new int[]{};
        int[] root = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            int A = find(edge[0], root);
            int B = find(edge[1], root);
            if (A == B) return edge;
            root[A] = B;
        }
        return new int[]{};
    }
    
    private int find(int cur, int[] root) {
        return cur == root[cur] ? cur : find(root[cur], root);
    }
}