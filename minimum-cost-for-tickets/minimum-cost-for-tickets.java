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

//O(N)
class Solution {
    int[] dp;
    int[] nextDay = new int[]{1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, 365001);
        return dfs(0, costs, days);
    }
    
    private int dfs(int idx, int[] costs, int[] days) {
        if (idx > days.length - 1) {
            return 0;
        }
        if (dp[idx] != 365001) return dp[idx];
        int j = idx;
        for (int i = 0; i < 3; i++) {
            while (j < days.length && days[j] < days[idx] + nextDay[i]) j++;
            dp[idx] = Math.min(dp[idx], dfs(j, costs, days) + costs[i]);
        }
        return dp[idx];
    }
}
