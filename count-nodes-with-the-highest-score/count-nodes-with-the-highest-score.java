class Solution {
    long mx = Long.MIN_VALUE;
    int mxCount = 0;
    public int countHighestScoreNodes(int[] parents) {
        if (parents == null || parents.length == 0) return 0;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < parents.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < parents.length; i++) {
            tree.get(parents[i]).add(i);
        }
        dfs(tree, 0);
        return mxCount;
    }
    
    private int dfs(List<List<Integer>> tree, int cur) {
        int restChild = 0;
        long res = 1, next = 0;
        for (int child : tree.get(cur)) {
            next = dfs(tree, child);
            res *= next;
            restChild += next;
        }
        int par = tree.size() - 1 - restChild;
        res *= par != 0 ? par : 1;
        if (mx == res) {
            mxCount++;
        } else if (res > mx) {
            mxCount = 1;
            mx = res;
        }
        return restChild + 1;
    }
}