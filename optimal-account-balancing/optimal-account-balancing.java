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
        int[] debt = new int[map.size()];
        int idx = 0;
        for (int i : map.values()) {
            debt[idx++] = i;
        }
        return backtracking(debt, 0);
    }
    
    private int backtracking(int[] debt, int cur) {
        while (cur < debt.length && debt[cur] == 0) cur++;
        if (cur == debt.length) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = cur + 1; i < debt.length; i++) {
            if (debt[i] * debt[cur] < 0) {
                debt[i] += debt[cur];
                min = Math.min(min, backtracking(debt, cur + 1) + 1);
                debt[i] -= debt[cur];
            }
        }
        return min;
    }
}