class Solution {
    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            int sender = transaction[0];
            int recevier = transaction[1];
            int amount = transaction[2];
            map.put(sender, map.getOrDefault(sender, 0) - amount);
            map.put(recevier, map.getOrDefault(recevier, 0) + amount);
        }
        List<Integer> debt = map.values().stream().filter(v -> v != 0).collect(Collectors.toList());
        int[] dp = new int[1 << debt.size()];
        int[] sum = new int[1 << debt.size()];
        for (int i = 0; i < dp.length; i++) {
            int setBit = 1;
            for (int j = 0; j < debt.size(); j++) {
                if ((i & setBit) == 0) {
                    int nxt = i | setBit;
                    sum[nxt] = sum[i] + debt.get(j);
                    if (sum[nxt] == 0) {
                        dp[nxt] = Math.max(dp[i] + 1, dp[nxt]);
                    } else {
                        dp[nxt] = Math.max(dp[i], dp[nxt]);
                    }
                }
                setBit <<= 1;
            }
        }
        return debt.size() - dp[dp.length - 1];
    }
    
}