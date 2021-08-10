class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    
    private int dfs(int x, int y) {
        String cur = x + "." + y;
        if (memo.containsKey(cur)) return memo.get(cur);
        
        if (x == 0 && y == 0) return 0;
        
        if (x + y == 2) return 2;
        
        int dis = Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2)), 
                          dfs(Math.abs(x - 2), Math.abs(y - 1))) + 1;
        memo.put(cur, dis);
        return dis;
        
    }
    
    public int minKnightMoves(int x, int y) {
        return dfs(Math.abs(x), Math.abs(y));
    }
}