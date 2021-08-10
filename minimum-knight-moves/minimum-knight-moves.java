// dfs, 40 mins
class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    
    private int dfs(int x, int y) {
        String cur = x + "." + y;
        if (memo.containsKey(cur)) return memo.get(cur);
        
        if (x == 0 && y == 0) return 0;
        
        // if x or y greater than 2, we can always reduced it below 2
        // so (1, 0), (0 ,1), (1, 1), (2, 0), (0, 2) are all possible base case
        // the first two can convert to the last two, so we check x + y == 2
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
