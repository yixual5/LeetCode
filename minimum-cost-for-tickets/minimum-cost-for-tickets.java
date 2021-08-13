class Solution {
    int[] dp = new int[366];
    public int mincostTickets(int[] days, int[] costs) {
        
        Set<Integer> s = new HashSet<Integer>();
        for (int day : days) {
            s.add(day);
        }
        return dfs(1, costs, s);
    }
    
    private int dfs(int day, int[] costs, Set<Integer> s) {
        if (day > 365) {
            return 0;
        }
        if (dp[day] != 0) return dp[day];
        int temp = 0;
        if (s.contains(day)) {
            dp[day] = Math.min(dfs(day + 1, costs, s) + costs[0], dfs(day + 7, costs, s) + costs[1]);
            dp[day] = Math.min(dp[day], dfs(day + 30, costs, s) + costs[2]);
        } else {
            dp[day] = dfs(day + 1, costs, s);
        }
        return dp[day];
    }
}